package fetch_unit

import chisel3._
import circt.stage.ChiselStage


class FetchUnitIO3 extends Bundle {
    val npc: UInt = Input(UInt(32.W))
    val npc_en: Bool = Input(Bool())

    val pc: UInt = Output(UInt(32.W))
}


class FetchUnit3 extends Module {
    val io: FetchUnitIO3 = IO(new FetchUnitIO3)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := Mux(io.npc_en, io.npc, pc + 4.U)
    io.pc := pc
}


object VerilogMain3 extends App {
    ChiselStage.emitSystemVerilogFile(new FetchUnit3)
}
