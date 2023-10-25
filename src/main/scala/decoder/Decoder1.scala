package decoder

import circt.stage.ChiselStage
import chisel3._,
       chisel3.util._


class DecoderIO1 extends Bundle {
  val inst: UInt = Input(UInt(32.W))
  val ctrl: Vec[Bool] = Input(Vec(4, Bool()))

  val opcode: UInt      = Output(UInt(7.W))
  val rAddr : Vec[UInt] = Output(Vec(3, UInt(5.W)))
  val funct3: UInt      = Output(UInt(3.W))
  val funct7: UInt      = Output(UInt(7.W))
  val imm   : SInt      = Output(SInt(32.W))
}


class Decoder1 extends RawModule {
  val io: DecoderIO1 = IO(new DecoderIO1)


  /********************
   * Interconnections *
   ********************/

  Seq(
    io.opcode -> (6, 0),
    io.funct3 -> (14, 12),
    io.funct7 -> (31, 25)
  ).foreach(
    x => x._1 := io.inst(x._2._1, x._2._2)
  )

  Seq(
    (11, 7),   // rd
    (19, 15),  // rs1
    (24, 20)   // rs2
  ).zipWithIndex.foreach(
    x => io.rAddr(x._2) := io.inst(x._1._1, x._1._2)
  )

  // Immediate Generation
  // Default: I immediate
  io.imm := MuxCase(io.inst(31, 20).asSInt, Seq(
    Cat(io.inst(31, 25), io.inst(11, 7)),
    Cat(io.inst(31), io.inst(7), io.inst(30, 25), io.inst(11, 8), 0.U(1.W)),
    Cat(io.inst(31, 12), 0.U(12.W)),
    Cat(io.inst(31), io.inst(19, 12), io.inst(20), io.inst(30, 21), 0.U(1.W))
  ).zipWithIndex.map(
    x => io.ctrl(x._2) -> x._1.asSInt
  ))
}


object VerilogMain1 extends App {
  ChiselStage.emitSystemVerilogFile(new Decoder1)
}