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
- [ ] 11: `jalr` (internal calculation) and unaligned memory access stall selection (explicit naming); `pc + 4`, `jal` and `pc` next pc.
