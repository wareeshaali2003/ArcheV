module PC(
  input         clock,
                reset,
                io_stall,
  output [31:0] io_pc
);

  reg [31:0] pc;
  always @(posedge clock) begin
    if (reset)
      pc <= 32'h0;
    else if (io_stall) begin
    end
    else
      pc <= pc + 32'h4;
  end // always @(posedge)
  assign io_pc = pc;
endmodule