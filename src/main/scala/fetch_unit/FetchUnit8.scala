package fetch_unit

import chisel3._
import circt.stage.ChiselStage
import chisel3.util._


import chisel3._

import chisel3.experimental.BundleLiterals._

 
class FetchUnitIO8 extends Bundle {
    val npc: UInt = Input(UInt(32.W))
    val ctrl: Vec[Bool] = Input(Vec(2, Bool()))

    val pc: UInt = Output(UInt(32.W))
}


class FetchUnit8 extends Module {
    val io: FetchUnitIO8 = IO(new FetchUnitIO8)

    // Program Counter
    val pc: UInt = RegInit(0.U(32.W))


    /********************
     * Interconnections *
     ********************/

    pc    := MuxCase(pc + 4.U, Seq(
      0 -> io.npc,
      1 -> pc
    ).map(x => io.ctrl(x._1) -> x._2))
    io.pc := pc
}


// object VerilogMain8 extends App {
//     ChiselStage.emitSystemVerilogFile(new FetchUnit8)
// }
