module Control_Unit(
  input [6:0] opcode,
  input [2:0] funct3,
  input [6:0] funct7,

  output [1:0] alu_op,
  output jump,
         branch,
         mem_read,
         mem_write,
         alu_src,
         mem_to_reg,
         reg_write);


always @(*)
begin
  case(opcode) 
    4'b0010011:  // lui
      begin
        alu_src = 1'b0;
        mem_to_reg = 1'b0;
        reg_write = 1'b1;
        mem_read = 1'b0;
        mem_write = 1'b0;
        branch = 1'b0;
        alu_op = 2'b10;
        jump = 1'b0;   
      end
    4'b0010111:  // B-Type
      begin
        alu_src = 1'b1;
        mem_to_reg = 1'b0;
        reg_write = 1'b0;
        mem_read = 1'b0;
        mem_write = 1'b0;
        branch = 1'b1;
        alu_op = 2'b00;
        jump = 1'b0;   
      end
    4'b1101111:  // J-Type
      begin
        alu_src = 1'b0;
        mem_to_reg = 1'b0;
        reg_write = 1'b1;
        mem_read = 1'b0;
        mem_write = 1'b0;
        branch = 1'b0;
        alu_op = 2'b00;
        jump = 1'b1;   
      end
    4'b1100111:  // jalr
      begin
        alu_src = 1'b0;
        mem_to_reg = 1'b0;
        reg_write = 1'b1;
        mem_read = 1'b0;
        mem_write = 1'b0;
        branch = 1'b0;
        alu_op = 2'b00;
        jump = 1'b1;   
      end
    default:
      begin
        reg_write = 1'b0;
        alu_src = 1'b0;
        mem_to_reg = 1'b0;
        reg_write = 1'b0;
        mem_read = 1'b0;
        mem_write = 1'b0;
        beq = 1'b0;
        bne = 1'b0;
        alu_op = 2'b00;
        jump = 1'b0; 
      end
  endcase
end

endmodule
