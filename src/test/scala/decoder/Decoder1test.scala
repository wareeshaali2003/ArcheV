// package pc

// import chiseltest._
// import fetch_unit.PC1
// import org.scalatest.freespec.AnyFreeSpec

// class Decoder1test extends AnyFreeSpec with ChiselScalatestTester{
//     "Decoder1Test" in { 
//         test(new Decoder1()){ a=>
//         a.io.inst.poke(0.U)
//         a.io.ctrl(0).poke(1.U)
//         a.io.ctrl(1).poke(1.U)
//         a.io.ctrl(2).poke(1.U)
//         a.io.ctrl(3).poke(1.U)
//         a.io.opcode.expect(0.U)}
//         a.io.rAddr(0).expect(1.U)
//         a.io.rAddr(1).expect(1.U)
//         a.io.rAddr(2).expect(1.U)
//         a.io.rAddr(3).expect(1.U)
//         a.io.funct3.expect(0.U)
//         a.io.funct7.expect(0.U)
//         a.io.imm.expect(0.S)
//         }
//         }