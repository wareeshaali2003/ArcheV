package pc

import chisel3._
import circt.stage.ChiselStage


class PCIO2 extends Bundle {
    val stall: Bool = Input(Bool())

    val pc: UInt = Output(UInt(32.W))
}


class PC2 extends Module {
    val io: PCIO2 = IO(new PCIO2)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := Mux(io.stall, pc, pc + 4.U)
    io.pc := pc
}


object VerilogMain2 extends App {
    ChiselStage.emitSystemVerilogFile(new PC2)
}
