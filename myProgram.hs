import Sprockell

prog :: [Instruction]
prog = [ Branch regSprID (Rel 10)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 0)
       , Load (ImmValue 0) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 1)
       , EndProg
       , Load (ImmValue 1) regA
       , Compute Equal regSprID regA regC
       , Branch regC (Rel 7)
       , Load (ImmValue 2) regA
       , Compute Equal regSprID regA regC
       , Branch regC (Rel 17)
       , Load (ImmValue 3) regA
       , Compute Equal regSprID regA regC
       , Branch regC (Rel 23)
       , Load (ImmValue 4300) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 7)
       , Load (ImmValue 1) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 8)
       , Load (ImmValue 13) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 9)
       , EndProg
       , Load (ImmValue 200) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 5)
       , Load (ImmValue 1000) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 6)
       , EndProg
       , Load (ImmValue 400) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 2)
       , Load (ImmValue 200) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 3)
       , Load (ImmValue 500) regA
       , Push regA
       , Pop regA
       , Store regA (DirAddr 4)
       , EndProg
       ]

main = run [prog,prog,prog,prog]
