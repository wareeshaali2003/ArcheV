module PC4(
  input         clock,
                reset,
  input  [31:0] io_imm,
  input         io_npc_en,
  output [31:0] io_pc
);

  reg [31:0] pc;
  always @(posedge clock) begin
    if (reset)
      pc <= 32'h0;
    else if (io_npc_en)
      pc <= pc + io_imm;
    else
      pc <= pc + 32'h4;
  end // always @(posedge)
  assign io_pc = pc;
endmodule

