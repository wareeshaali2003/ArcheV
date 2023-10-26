module FetchUnit(
  input         clock,
                reset,
  input  [31:0] io_imm,
                io_rs1,
  input  [1:0]  io_npc_en,
  output [31:0] io_pc
);
  reg [31:0] pc;
  always @(posedge clock) begin
    if (reset)
      pc <= 32'h0;
    else if (io_npc_en == 2'h2)
      pc <= io_rs1 + io_imm;
    else if (io_npc_en == 2'h1)
      pc <= pc + io_imm;
    else
      pc <= pc + 32'h4;
  end
  assign io_pc = pc;
endmodule
