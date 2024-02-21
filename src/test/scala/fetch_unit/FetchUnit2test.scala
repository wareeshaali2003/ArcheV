package fetch_unit

import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec

import chisel3._
import org.scalatest._



class FetchUnit2test extends AnyFreeSpec with ChiselScalatestTester{
    "FetchUnit2Test" in { 
        test(new FetchUnit2()){ a=>
        a.io.stall.poke(0.B)
        a.clock.step(20)
        a.io.pc.expect(0.U)
       
        }
        }}