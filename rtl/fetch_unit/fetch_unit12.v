module FetchUnit(
  input         clock,
                reset,
                io_ctrl_0,
                io_ctrl_1,
  input  [31:0] io_imm,
                io_rs1,
  output [31:0] io_pc
);
  reg [31:0] pc;
  always @(posedge clock) begin
    if (reset)
      pc <= 32'h0;
    else if (io_ctrl_0) begin
    end
    else if (io_ctrl_1)
      pc <= io_rs1 + io_imm;
    else
      pc <= pc + 32'h4;
  end
  assign io_pc = pc;
endmodule
