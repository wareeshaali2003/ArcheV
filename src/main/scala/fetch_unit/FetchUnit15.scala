package fetch_unit

import circt.stage.ChiselStage,
       chisel3._,
       chisel3.util._


import chisel3.experimental.BundleLiterals._

 
class FetchUnit15 extends Module {
    //noinspection TypeAnnotation
    val io = IO(new Bundle {
        val stall_en: Bool = Input(Bool())
        val br_en   : Bool = Input(Bool())
        val imm     : SInt = Input(SInt(32.W))

        val pc: UInt = Output(UInt(32.W))
    })

    val pc: UInt = RegInit(0.U(32.W))

    pc := MuxCase(pc + 4.U, Seq(
        io.stall_en -> pc,
        io.br_en    -> (pc + io.imm.asUInt)
    ))
    io.pc := pc
}


// object VerilogMain15 extends App {
//     ChiselStage.emitSystemVerilogFile(new FetchUnit15)
// }
