import Sprockell

prog :: [Instruction]
prog = [ Branch regSprID (Rel 36)
       , Load (ImmValue 1) regA
       , WriteInstr regA (DirAddr 0)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , WriteInstr regA (DirAddr 1)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , WriteInstr regA (DirAddr 2)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , WriteInstr regA (DirAddr 3)
       , Load (ImmValue 0) regA
       , WriteInstr regA (DirAddr 0)
       , ReadInstr (DirAddr 6)
       , Receive regA
       , Branch regA (Rel (-2))
       , ReadInstr (DirAddr 2)
       , Receive regA
       , Push regA
       , ReadInstr (DirAddr 3)
       , Receive regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Add regA regB regA
       , Push regA
       , Pop regA
       , WriteInstr regA (DirAddr 1)
       , ReadInstr (DirAddr 1)
       , Receive regA
       , WriteInstr regA numberIO
       , EndProg
       , Load (ImmValue 1) regA
       , Compute Equal regSprID regA regC
       , Branch regC (Rel 7)
       , Load (ImmValue 2) regA
       , Compute Equal regSprID regA regC
       , Branch regC (Rel 18)
       , Load (ImmValue 3) regA
       , Compute Equal regSprID regA regC
       , Branch regC (Rel 31)
       , Load (ImmValue 1) regA
       , WriteInstr regA (DirAddr 4)
       , Nop
       , Nop
       , ReadInstr (DirAddr 0)
       , Receive regA
       , Branch regA (Rel (-2))
       , Load (ImmValue 2) regA
       , Push regA
       , Pop regA
       , WriteInstr regA (DirAddr 2)
       , Load (ImmValue 0) regA
       , WriteInstr regA (DirAddr 4)
       , EndProg
       , Load (ImmValue 1) regA
       , WriteInstr regA (DirAddr 6)
       , Nop
       , Nop
       , ReadInstr (DirAddr 0)
       , Receive regA
       , Branch regA (Rel (-2))
       , ReadInstr (DirAddr 4)
       , Receive regA
       , Branch regA (Rel (-2))
       , ReadInstr (DirAddr 5)
       , Receive regA
       , Branch regA (Rel (-2))
       , Load (ImmValue 0) regA
       , WriteInstr regA (DirAddr 6)
       , EndProg
       , Load (ImmValue 1) regA
       , WriteInstr regA (DirAddr 5)
       , Nop
       , Nop
       , ReadInstr (DirAddr 0)
       , Receive regA
       , Branch regA (Rel (-2))
       , Load (ImmValue 3) regA
       , Push regA
       , Pop regA
       , WriteInstr regA (DirAddr 3)
       , Load (ImmValue 0) regA
       , WriteInstr regA (DirAddr 5)
       , EndProg
       ]

main = run [prog,prog,prog,prog]
