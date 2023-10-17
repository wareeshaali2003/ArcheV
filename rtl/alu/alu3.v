module ALU(
 input  [31:0] a,  //src1
 input  [31:0] b,  //src2
 input  [2:0] alu_control, //function sel
 
 output reg [31:0] result,  //result 
    );

always @(*)
begin 
 case(alu_control)
 3'b000: result = a < b; // less than
 3'b001: result = a <= b; // less than equal
 3'b011: result = a > b;  // greater than
 3'b100: result = a >= b;  // greater than equal
 default:result = a < b; // less than
 endcase
end
 
endmodule
