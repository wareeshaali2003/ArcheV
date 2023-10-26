module FetchUnit(
  input         clock,
                reset,
  input  [31:0] io_npc,
  input         io_npc_en,
  output [31:0] io_pc
);
  reg [31:0] pc;
  always @(posedge clock) begin
    if (reset)
      pc <= 32'h0;
    else if (io_npc_en)
      pc <= io_npc;
    else
      pc <= pc + 32'h4;
  end
  assign io_pc = pc;
endmodule
