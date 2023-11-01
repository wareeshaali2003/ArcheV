package fetch_unit

import circt.stage.ChiselStage
import chisel3._
import chisel3.util._


class FetchUnit12 extends Module {
    //noinspection TypeAnnotation
    val io = IO(new Bundle {
        val ctrl: Vec[Bool] = Input(Vec(2, Bool()))
        val imm : SInt = Input(SInt(32.W))
        val rs1 : SInt = Input(SInt(32.W))

        val pc: UInt = Output(UInt(32.W))
    })

    val pc: UInt = RegInit(0.U(32.W))

    pc := MuxCase(pc + 4.U, Seq(
        pc, (io.rs1 + io.imm).asUInt
    ).zipWithIndex.map(
        x => io.ctrl(x._2) -> x._1
    ))
    io.pc := pc
}


object VerilogMain12 extends App {
    ChiselStage.emitSystemVerilogFile(new FetchUnit12)
}
