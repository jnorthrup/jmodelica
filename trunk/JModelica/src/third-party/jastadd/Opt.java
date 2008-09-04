package org.jmodelica.ast;
public class Opt<T extends ASTNode> extends ASTNode<T> implements Cloneable {
  public Opt() {
    super();
  }

  public Opt(T opt) {
    setChild(opt, 0);
  }
}
