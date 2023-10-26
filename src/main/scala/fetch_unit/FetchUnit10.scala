package fetch_unit

import circt.stage.ChiselStage
import chisel3._
import chisel3.util._


class FetchUnit10 extends Module {
    //noinspection TypeAnnotation
    val io = IO(new Bundle {
        val ctrl: Vec[Bool] = Input(Vec(2, Bool()))
        val imm : SInt = Input(SInt(32.W))

        val pc: UInt = Output(UInt(32.W))
    })

    val pc: UInt = RegInit(0.U(32.W))

    pc := MuxCase(pc + 4.U, Seq(
        pc, pc + io.imm.asUInt
    ).zipWithIndex.map(
        x => io.ctrl(x._2) -> x._1
    ))
    io.pc := pc
}


object VerilogMain10 extends App {
    ChiselStage.emitSystemVerilogFile(new FetchUnit10)
}