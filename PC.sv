module PC(	// <stdin>:3:3
  input         clock,	// <stdin>:4:11
                reset,	// <stdin>:5:11
  output [31:0] io_pc	// src/main/scala/pc/PC.scala:12:22
);

  reg [31:0] pc;	// src/main/scala/pc/PC.scala:15:27
  always @(posedge clock) begin	// <stdin>:4:11
    if (reset)	// <stdin>:4:11
      pc <= 32'h0;	// src/main/scala/pc/PC.scala:15:27
    else	// <stdin>:4:11
      pc <= pc + 32'h4;	// src/main/scala/pc/PC.scala:15:27, :22:17
  end // always @(posedge)
    initial begin	// <stdin>:3:3
      automatic logic [31:0] _RANDOM[0:0];	// <stdin>:3:3
        pc = _RANDOM[/*Zero width*/ 1'b0];	// <stdin>:3:3, src/main/scala/pc/PC.scala:15:27
    end // initial
  assign io_pc = pc;	// <stdin>:3:3, src/main/scala/pc/PC.scala:15:27
endmodule

