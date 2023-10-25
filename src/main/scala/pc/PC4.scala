package pc

import chisel3._
import circt.stage.ChiselStage


class PCIO4 extends Bundle {
    val imm: SInt = Input(SInt(32.W))
    val jal_en: Bool = Input(Bool())

    val pc: UInt = Output(UInt(32.W))
}


class PC4 extends Module {
    val io: PCIO4 = IO(new PCIO4)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := Mux(io.jal_en, pc + io.imm.asUInt, pc + 4.U)
    io.pc := pc
}


object VerilogMain4 extends App {
    ChiselStage.emitSystemVerilogFile(new PC4)
}
