module ALU(
  input [31:0] a,
  input [31:0] b,
  input [2:0] alu_control,
  
  output [31:0] result);


always @(*)
begin 
  case(alu_control)
    3'b000: result = a + b;
    3'b001: result = a < b;
    3'b011: result = a | b;
    3'b100: result = a >> b;
    3'b100: result = a >= b;
    default:result = a + b;
  endcase
end
 
endmodule
