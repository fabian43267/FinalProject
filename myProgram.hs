import Sprockell

prog :: [Instruction]
prog = [ Branch regSprID (Rel 127)
       , Load (ImmValue 1) regA
       , WriteInstr regA (DirAddr 0)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , Load (ImmValue 5) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 2)
       , Load (ImmValue 4) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 3)
       , Load (ImmValue 3) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 4)
       , Load (ImmValue 2) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 5)
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 6)
       , Load (ImmValue 5) regA
       , Push regA
       , Load (ImmValue 3) regA
       , Push regA
       , Load (ImmValue 2) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Mul regA regB regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Add regA regB regA
       , Push regA
       , Load (ImmValue 4) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Sub regA regB regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 6)
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 6)
       , Load (DirAddr 6) regA
       , Push regA
       , Load (ImmValue 5) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute LtE regA regB regA
       , Push regA
       , Pop regB
       , Load (ImmValue 0) regA
       , Compute Equal regA regB regB
       , Branch regB (Rel 33)
       , Load (DirAddr 0) regA
       , Push regA
       , Load (DirAddr 6) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Equal regA regB regA
       , Push regA
       , Pop regB
       , Load (ImmValue 0) regA
       , Compute Equal regA regB regB
       , Branch regB (Rel 6)
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , Jump (Rel 5)
       , Load (ImmValue 3) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , Load (DirAddr 6) regA
       , Push regA
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Add regA regB regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 6)
       , Jump (Rel (-43))
       , Load (DirAddr 0) regA
       , Push regA
       , Load (ImmValue 5) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Lt regA regB regA
       , Push regA
       , Pop regB
       , Load (ImmValue 0) regA
       , Compute Equal regA regB regB
       , Branch regB (Rel 12)
       , Load (DirAddr 0) regA
       , Push regA
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Add regA regB regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , Jump (Rel (-22))
       , Load (DirAddr 0) regA
       , WriteInstr regA numberIO
       , EndProg
       ]

main = run [prog]
