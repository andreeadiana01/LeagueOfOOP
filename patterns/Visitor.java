package patterns;

import heroes.Knight;
import heroes.Wizard;
import heroes.Pyromancer;
import heroes.Rogue;

public interface Visitor {

     void visit(Knight knight);
     void visit(Pyromancer pyromancer);
     void visit(Rogue rogue);
     void visit(Wizard wizard);
}
