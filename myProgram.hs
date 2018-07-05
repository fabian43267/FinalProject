import Sprockell

prog :: [Instruction]
prog = [ Branch regSprID (Rel 136)
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , Load (ImmValue 2) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 1)
       , Load (ImmValue 3) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 2)
       , Load (ImmValue 4) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 3)
       , Load (ImmValue 5) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 4)
       , Load (ImmValue 6) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 5)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 6)
       , Load (DirAddr 6) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , Push regA
       , Load (ImmValue 4) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Lt regA regB regC
       , Load (ImmValue 0) regA
       , Compute Equal regA regC regC
       , Branch regC (Rel 50)
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
       , Load (DirAddr 6) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , Push regA
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute LtE regA regB regC
       , Load (ImmValue 0) regA
       , Compute Equal regA regC regC
       , Branch regC (Rel 13)
       , Load (DirAddr 6) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Push regA
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , Pop regB
       , Store regA (IndAddr regB)
       , Jump (Rel 12)
       , Load (DirAddr 6) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Push regA
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regA
       , Pop regB
       , Store regA (IndAddr regB)
       , Jump (Rel (-63))
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , WriteInstr regA numberIO
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , WriteInstr regA numberIO
       , Load (ImmValue 2) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , WriteInstr regA numberIO
       , Load (ImmValue 3) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , WriteInstr regA numberIO
       , Load (ImmValue 4) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , WriteInstr regA numberIO
       , Load (ImmValue 5) regA
       , Push regA
       , Pop regA
       , Load (ImmValue 0) regB
       , Compute Add regA regB regA
       , Load (IndAddr regA) regA
       , WriteInstr regA numberIO
       , EndProg
       ]

main = run [prog]
