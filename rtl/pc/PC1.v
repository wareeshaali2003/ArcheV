module PC1(
  input         clock,
                reset,
  output [31:0] io_pc
);

  reg [31:0] pc;
  always @(posedge clock) begin
    if (reset)
      pc <= 32'h0;
    else
      pc <= pc + 32'h4;
  end // always @(posedge)
  assign io_pc = pc;
endmodule