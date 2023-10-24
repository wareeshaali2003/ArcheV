package pc

import chisel3._


class PCIO extends Bundle {
    val pc: UInt = Output(UInt(32.W))
}


class PC1 extends Module {
    val io: PCIO = IO(new PCIO)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := pc + 4.U
    io.pc := pc
}


import circt.stage.ChiselStage

object VerilogMain extends App {
    ChiselStage.emitSystemVerilogFile(new PC1)
}