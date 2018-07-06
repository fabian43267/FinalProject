import Sprockell

prog :: [Instruction]
prog = [ Branch regSprID (Rel 38)
       , Load (ImmValue 1) regA
       , WriteInstr regA (DirAddr 0)
       , Load (ImmValue 1) regA
       , Push regA
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Equal regA regB regA
       , Push regA
       , Load (ImmValue 2) regA
       , Push regA
       , Load (ImmValue 5) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Lt regA regB regA
       , Push regA
       , Load (ImmValue 3) regA
       , Push regA
       , Load (ImmValue 4) regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Equal regA regB regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute And regA regB regA
       , Push regA
       , Pop regB
       , Pop regA
       , Compute Or regA regB regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , EndProg
       ]

main = run [prog]
