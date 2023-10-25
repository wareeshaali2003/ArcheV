package pc

import chisel3._
import circt.stage.ChiselStage
import chisel3.util.MuxLookup


class PCIO6 extends Bundle {
    val imm: SInt = Input(SInt(32.W))
    val rs1: SInt = Input(SInt(32.W))
    val npc_en: Bool = Input(Bool())

    val pc: UInt = Output(UInt(32.W))
}


class PC6 extends Module {
    val io: PCIO6 = IO(new PCIO6)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := MuxLookup(io.npc_en, pc + 4.U)(Seq(
      0.B -> (pc + io.imm.asUInt),
      1.B -> (io.rs1 + io.imm).asUInt
    ))
    io.pc := pc
}


object VerilogMain6 extends App {
    ChiselStage.emitSystemVerilogFile(new PC6)
}
