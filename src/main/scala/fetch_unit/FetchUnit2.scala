package fetch_unit

import chisel3._
import circt.stage.ChiselStage


class FetchUnitIO2 extends Bundle {
    val stall: Bool = Input(Bool())

    val pc: UInt = Output(UInt(32.W))
}


class FetchUnit2 extends Module {
    val io: FetchUnitIO2 = IO(new FetchUnitIO2)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := Mux(io.stall, pc, pc + 4.U)
    io.pc := pc
}


object VerilogMain2 extends App {
    ChiselStage.emitSystemVerilogFile(new FetchUnit2)
}
