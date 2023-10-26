package fetch_unit

import chisel3._
import circt.stage.ChiselStage


class FetchUnitIO1 extends Bundle {
    val pc: UInt = Output(UInt(32.W))
}


class FetchUnit1 extends Module {
    val io: FetchUnitIO1 = IO(new FetchUnitIO1)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := pc + 4.U
    io.pc := pc
}



object VerilogMain1 extends App {
    emitVerilog(new FetchUnit1)
}