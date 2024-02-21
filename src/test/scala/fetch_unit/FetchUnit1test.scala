package fetch_unit

import chisel3._
import chiseltest._
// import fetch_unit.PC1
import org.scalatest.freespec.AnyFreeSpec

import org.scalatest._
import chiseltest._


class FetchUnit1test extends AnyFreeSpec with ChiselScalatestTester{
    "FetchUnit1Test" in { 
        test(new FetchUnit1()){ a=>
        a.clock.step(20)
        a.io.pc.expect(1.U)
        }
        }}