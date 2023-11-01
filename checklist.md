# Module Checklist

## Fetch Unit
- [ ] 1: Non-input; `pc + 4` next pc.
- [ ] 2: Unaligned memory access stall input; `pc` and `pc + 4` next pc.
- [ ] 3: `npc` input (external calculation) input; `pc + 4` next pc.
- [ ] 4: `jal` input (internal calculation) input; `pc + 4` next pc.
- [ ] 5: `jalr` input (internal calculation) input; `pc + 4` next pc.
- [ ] 6: `jal` and `jalr` selection (internal calculation); `jal`, `jalr` and `pc + 4` next pc.
- [ ] 7: `npc` (external calculation) and unaligned memory access stall selection (explicit naming); `pc + 4`, `npc` and `pc` next pc.
- [ ] 8: `npc` (external calculation) and unaligned memory access stall selection (boolean vectors); `pc + 4`, `npc` and `pc` next pc.
- [ ] 9: `jal` (internal calculation) and unaligned memory access stall selection (explicit naming); `pc + 4`, `jal` and `pc` next pc.
- [ ] 10: `jal` (internal calculation) and unaligned memory access stall selection (boolean vector); `pc + 4`, `jal` and `pc` next pc.
- [ ] 11: `jalr` (internal calculation) and unaligned memory access stall selection (explicit naming); `pc + 4`, `jalr` and `pc` next pc.
- [ ] 12: `jalr` (internal calculation) and unaligned memory access stall selection (boolean vector); `pc + 4`, `jalr` and `pc` next pc.
- [ ] 13: `jal` and `jalr` (internal calculation), and unaligned memory access stall selection (explicit naming); `pc + 4`, `jalr`, `jal` and `pc` next pc
- [ ] 14: `jal` and `jalr` (internal calculation), and unaligned memory access stall selection (boolean vector); `pc + 4`, `pc`, `jalr` and `jal` next pc
- [ ] 15: `branch` and unaligned memory access stall selection (explicit naming); `pc` and `branch` next pc
- [ ] 16: `jal` and `jalr` (internal calculation), and unaligned memory access stall selection (explicit naming); `pc + 4`, `jalr`, `jal` and `pc` next pc
- [ ] 17: `jal` and `jalr` (internal calculation), and unaligned memory access stall selection (explicit naming); `pc + 4`, `pc`, `jal` and `jalr` next pc
