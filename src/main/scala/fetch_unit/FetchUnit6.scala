package fetch_unit

import chisel3._
import circt.stage.ChiselStage
import chisel3.util._


class FetchUnitIO6 extends Bundle {
    val imm: SInt = Input(SInt(32.W))
    val rs1: SInt = Input(SInt(32.W))
    val npc_en: UInt = Input(UInt(2.W))

    val pc: UInt = Output(UInt(32.W))
}


class FetchUnit6 extends Module {
    val io: FetchUnitIO6 = IO(new FetchUnitIO6)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := MuxLookup(io.npc_en, pc + 4.U)(Seq(
      pc + io.imm.asUInt, (io.rs1 + io.imm).asUInt
    ).zipWithIndex.map(
        v => (v._2 + 1).U -> v._1
    ))
    io.pc := pc
}


object VerilogMain6 extends App {
    ChiselStage.emitSystemVerilogFile(new FetchUnit6)
}
