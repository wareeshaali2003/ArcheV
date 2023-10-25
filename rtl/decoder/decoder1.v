module Decoder1(
  input  [31:0] io_inst,
  input         io_ctrl_0,
                io_ctrl_1,
                io_ctrl_2,
                io_ctrl_3,
  output [6:0]  io_opcode,
  output [4:0]  io_rAddr_0,
                io_rAddr_1,
                io_rAddr_2,
  output [2:0]  io_funct3,
  output [6:0]  io_funct7,
  output [31:0] io_imm
);

  wire [20:0] _io_imm_T_21 =
    io_ctrl_3
      ? {io_inst[31], io_inst[19:12], io_inst[20], io_inst[30:21], 1'h0}
      : {{9{io_inst[31]}}, io_inst[31:20]};
  assign io_opcode = io_inst[6:0];
  assign io_rAddr_0 = io_inst[11:7];
  assign io_rAddr_1 = io_inst[19:15];
  assign io_rAddr_2 = io_inst[24:20];
  assign io_funct3 = io_inst[14:12];
  assign io_funct7 = io_inst[31:25];
  assign io_imm =
    io_ctrl_0
      ? {{20{io_inst[31]}}, io_inst[31:25], io_inst[11:7]}
      : io_ctrl_1
          ? {{20{io_inst[31]}}, io_inst[7], io_inst[30:25], io_inst[11:8], 1'h0}
          : io_ctrl_2 ? {io_inst[31:12], 12'h0} : {{11{_io_imm_T_21[20]}}, _io_imm_T_21};
endmodule

