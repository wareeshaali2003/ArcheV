package fetch_unit

import circt.stage.ChiselStage,
       chisel3._,
       chisel3.util._


class FetchUnit13 extends Module {
    //noinspection TypeAnnotation
    val io = IO(new Bundle {
        val imm     : SInt = Input(SInt(32.W))
        val rs1     : SInt = Input(SInt(32.W))
        val stall_en: Bool = Input(Bool())
        val jalr_en : Bool = Input(Bool())
        val jal_en  : Bool = Input(Bool())

        val pc: UInt = Output(UInt(32.W))
    })

    val pc: UInt = RegInit(0.U(32.W))

    pc := MuxCase(pc + 4.U, Seq(
        io.stall_en -> pc,
        io.jal_en   -> (pc + io.imm.asUInt),
        io.jalr_en  -> (io.rs1 + io.imm).asUInt
    ))
    io.pc := pc
}


object VerilogMain13 extends App {
    ChiselStage.emitSystemVerilogFile(new FetchUnit13)
}
