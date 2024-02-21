package fetch_unit

import chisel3._
// import circt.stage.ChiselStage
import chisel3.util._




import chisel3.experimental.BundleLiterals._

 
class FetchUnitIO7 extends Bundle {
    val npc: UInt = Input(UInt(32.W))
    val npc_en: Bool = Input(Bool())
    val stall_en: Bool = Input(Bool())

    val pc: UInt = Output(UInt(32.W))
}


class FetchUnit7 extends Module {
    val io: FetchUnitIO7 = IO(new FetchUnitIO7)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := MuxCase(pc + 4.U, Seq(
      io.npc_en -> io.npc,
      io.stall_en -> pc
    ))
    io.pc := pc
}


// object VerilogMain7 extends App {
//     ChiselStage.emitSystemVerilogFile(new FetchUnit7)
// }
