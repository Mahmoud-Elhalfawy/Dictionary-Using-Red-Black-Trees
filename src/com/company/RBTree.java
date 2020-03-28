package com.company;

public class RBTree {
    public static final Node nil=new Node(null,null);
    public Node root;
    public long count;
    int flag=0;
    public RBTree(){
    root=nil;
    }

    public long getCount() {
        return count;
    }

    public void insert(Node node){
    Node temp=root;
    if(root==nil){
        root=node;
        root.setParent(nil);
    }else{
        node.setColor("red");
        while(true){
            int x=compare(node.getValue(),temp.getValue());
            if(x<0){
                if (temp.getLeft()==nil){
                    temp.setLeft(node);
                    //System.out.println(node.getValue());
                    node.setParent(temp);
                    break;
                }else
                    temp=temp.getLeft();
            }else if(x>=0){

                if (temp.getRight()==nil){
                   // System.out.println(node.getValue());
                    temp.setRight(node);
                    node.setParent(temp);
                    break;
                }else
                    temp=temp.getRight();
            }
        }

        fix(node);
    }
}


public void fix(Node node){
        flag=0;
    while(node.getParent().getColor().equals("red")){
        Node uncle=nil;
        if(node.getParent()==node.getParent().getParent().getLeft()) {
            //System.out.println("hna");
            uncle = node.getParent().getParent().getRight();
            if(uncle!=nil && uncle.getColor().equals("red")){
                node.getParent().setColor("black");
                uncle.setColor("black");
                node.getParent().getParent().setColor("red");
                node=node.getParent().getParent();
                continue;
            }

            if (node.getParent().getRight()==node){
                node=node.getParent();
                rotateLeft(node);
              //  System.out.println("hna tany");
            }
            node.getParent().setColor("black");
            node.getParent().getParent().setColor("red");
            rotateRight(node.getParent().getParent());
            root.setColor("black");

        }
            else if(node.getParent()==node.getParent().getParent().getRight()) {
            uncle = node.getParent().getParent().getLeft();
            if (uncle != nil && uncle.getColor().equals("red")) {
                node.getParent().setColor("black");
                uncle.setColor("black");
                node.getParent().getParent().setColor("red");
                node = node.getParent().getParent();
                continue;
            }
            if (node.getParent().getLeft() == node) {
                node = node.getParent();
                rotateRight(node);
//                flag=1;
               // System.out.println("a7a");
            }
            node.getParent().setColor("black");
            node.getParent().getParent().setColor("red");

                rotateLeft(node.getParent().getParent());
              //  System.out.println("ana hna");

            }

    }
    root.setColor("black");
}

public void rotateLeft(Node X){
        Node B=nil;
Node Y=X.getRight();

if(X.getParent()!=nil){
    if(X==X.getParent().getLeft())
       X.getParent().setLeft(X.getRight());
    else
        X.getParent().setRight(X.getRight());
       Y.setParent(X.getParent());
        X.setParent(Y);
    if(Y!=nil)
         B=X.getRight().getLeft();
    if(B!=nil) {
       // System.out.println(B.getValue());
        B.setParent(X);
    }
    X.setRight(B);
    Y.setLeft(X);
}
else{
   // System.out.println("8yart elroot");
    Node right=root.getRight();
    right.setParent(nil);
   root.setParent(right);
   root.setRight(right.getLeft());
   right.getLeft().setParent(root);
   right.setLeft(root);
   root=right;
}

}


public void rotateRight(Node X){
    Node Y=X.getLeft();
    Node B=Y.getLeft();
    Node C=Y.getRight();
    if(X.getParent()!=nil) {
        if (X.getParent().getLeft() == X)
            X.getParent().setLeft(X.getLeft());
        else
            X.getParent().setRight(X.getLeft());
        Y.setParent(X.getParent());
        X.setParent(Y);

        if (C != nil)
            C.setParent(X);
        X.setLeft(C);
        Y.setRight(X);

    }else{
        Node left=root.getLeft();
        left.setParent(nil);
        root.setParent(left);
        root.setLeft(left.getRight());
        left.getRight().setParent(root);
        left.setRight(root);
        root=left;
    }


}



    public void printTree(Node root) {
        if (root == nil) {
            return;
        }
        printTree(root.getLeft());
        System.out.println("Color: "+root.getColor() +"\tValue: "+root.getValue()+"\tParent value: "+root.getParent().getValue() );
        count++;
        printTree(root.getRight());
    }


public int height(Node root){
        if(root==nil)
            return 0;
        int r=height(root.getRight());
        int l=height(root.getLeft());
        return 1+Math.max(l,r);
}

    public void count(Node root){
        if (root == nil) {
            return;
        }
        count(root.getLeft());
        count++;
        count(root.getRight());


    }



public int compare(String input,String tree){
        //returns 1 if (input > tree)
        return input.compareToIgnoreCase(tree);
}


public boolean search(String s,Node root){
        if(root==nil)
            return false;
        int x=compare(s,root.getValue());
        if(x==0)
            return true;
         if(x<0)
            return  search(s,root.getLeft());
         else
             return search(s,root.getRight());


}
}



