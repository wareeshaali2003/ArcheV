package pc

import chisel3._
import circt.stage.ChiselStage


class PCIO3 extends Bundle {
    val npc: UInt = Input(UInt(32.W))
    val npc_en: Bool = Input(Bool())

    val pc: UInt = Output(UInt(32.W))
}


class PC3 extends Module {
    val io: PCIO3 = IO(new PCIO3)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := Mux(io.npc_en, io.npc, pc + 4.U)
    io.pc := pc
}


object VerilogMain3 extends App {
    ChiselStage.emitSystemVerilogFile(new PC3)
}
