package com.company;

/**
 * Created by tau on 22/03/17.
 */
public class DList implements IList {

    DNode header;
    DNode trailer;
    int size;

    public DList() {
        header = new DNode(null);
        trailer = new DNode(null);
        header.next = trailer;
        trailer.prev= header;
    }



    public void addFirst(String elem) {
        DNode newNode = new DNode(elem);
        newNode.next = header.next;
        newNode.prev= header;
        header.next.prev= newNode;
        header.next = newNode;
        size++;
    }


    public void addLast(String elem) {
        DNode newNode = new DNode(elem);
        newNode.next = trailer;
        newNode.prev= trailer.prev;
        trailer.prev.next = newNode;
        trailer.prev= newNode;
        size++;
    }


    public void insertAt(int index, String elem) {
        DNode newNode = new DNode(elem);
        int i = 0;
        boolean inserted=false;
        for (DNode nodeIt = header; nodeIt != trailer && inserted==false; nodeIt = nodeIt.next) {
            if (i == index) {
                newNode.next = nodeIt.next;
                newNode.prev= nodeIt;
                nodeIt.next.prev= newNode;
                nodeIt.next = newNode;
                inserted=true;
                size++;
            }
            ++i;
        }
        if (!inserted) System.out.println("DList: Insertion out of bounds");
    }




    public boolean isEmpty() {
        return (header.next == trailer);
    }


    public boolean contains(String elem) {
        boolean found=false;
        for (DNode nodeIt = header.next; nodeIt != trailer && found==false; nodeIt = nodeIt.next) {
            if (nodeIt.elem.equals(elem)) {
                found=true;
            }
        }
        return found;
    }


    public int getIndexOf(String elem) {
        int index = -1;
        int pos=0;
        for (DNode nodeIt = header.next; nodeIt != trailer && index==-1; nodeIt = nodeIt.next) {
            if (nodeIt.elem.equals(elem)) {
                index=pos;
            }
            ++pos;

        }
        return index;
    }


    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("DList: List is empty");
            return;
        }
        header.next = header.next.next;
        header.next.prev= header;
        size--;
    }


    public void removeLast() {
        if (isEmpty()) {
            System.out.println("DList: List is empty");
            return;
        }
        trailer.prev= trailer.prev.prev;
        trailer.prev.next = trailer;
        size--;
    }


//	public void removeAll(String elem) {
//		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
//			if (nodeIt.elem.equals(elem)) {
//				nodeIt.prev.next = nodeIt.next;
//				nodeIt.next.prev= nodeIt.prev;
//				size--;
//			}
//		}
//	}

    public void removeAll(String elem) {
        int pos=-1;
        while ((pos=getIndexOf(elem))!=-1) {
            removeAt(pos);
        }
    }


    public void removeAt(int index) {
        int i = 0;
        boolean removed=false;
        for (DNode nodeIt = header.next; nodeIt != trailer && removed==false; nodeIt = nodeIt.next) {
            if (i == index) {
                nodeIt.prev.next = nodeIt.next;
                nodeIt.next.prev= nodeIt.prev;
                removed=true;
                size--;
            }
            ++i;
        }
        if (!removed) System.out.println("DList: Deletion out of bounds");
    }


    public int getSize() {

        return size;
    }


    public String getFirst() {
        String result=null;
        if (isEmpty()) {
            System.out.println("DList: List is empty");
        } else result=header.next.elem;
        return result;
    }

    public String getLast() {
        String result=null;

        if (isEmpty()) {
            System.out.println("DList: List is empty");
        } else result=trailer.prev.elem;

        return result;
    }


    public String getAt(int index) {
        int i = 0;
        String result=null;
        for (DNode nodeIt = header.next; nodeIt != trailer && result==null; nodeIt = nodeIt.next) {
            if (i == index) {
                result=nodeIt.elem;
            }
            ++i;
        }
        if (result==null) System.out.println("DList: Get out of bounds");
        return result;
    }

    public String toString() {
        String result = null;
        for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
            if (result == null) {
                result = nodeIt.elem;
            } else {
                result += "," + nodeIt.elem;
            }
        }
        return result == null ? "empty" : result;
    }


    private void replaceAt(int index, String newValue) {
        int i = 0;
        boolean replaced=false;
        for (DNode nodeIt = header.next; nodeIt != trailer && replaced==false; nodeIt = nodeIt.next) {
            if (i == index) {
                nodeIt.elem=newValue;
            }
            ++i;
        }
        if (replaced==false) System.out.println("DList: Get out of bounds");
        return;
    }

    public void sort() {
        for (int i=1;i<size;i++) {
            for (int j=0;j<size-i;j++) {
                if (getAt(j).compareTo(getAt(j+1))>0) {
                    String aux=getAt(j);
                    replaceAt(j,getAt(j+1));
                    replaceAt(j+1,aux);

                }
            }
        }
    }


    public void sort2() {
        if (isEmpty()) {
            System.out.println("Emtpy!!!");
            return;
        }


        boolean foundChange = true;
        while(foundChange) {
            foundChange = false;

            for(DNode nodeIt=header.next; nodeIt!=trailer.prev; nodeIt=nodeIt.next) {

                if (nodeIt.elem.compareTo(nodeIt.next.elem)>0) {
                    foundChange=true;
                    String aux=nodeIt.elem;
                    nodeIt.elem=nodeIt.next.elem;
                    nodeIt.next.elem=aux;


                }

            }


        }


    }


    public static void main(String[] args) {
        // incomplete test
        DList list = new DList();
        System.out.println(list.toString());
        System.out.println("isEmpty?" + list.isEmpty());
//		for (int i=0; i<100; i++) {
//			String newWord=getRandomString(5);
//			list.insertAt(i, newWord);
//
//		}
        list.addLast("Ana");

        list.removeLast();

        list.addLast("Isabel");

        list.removeFirst();

        list.addLast("Maria");

        list.addLast("Ana");

        list.addFirst("Pilar");


        list.insertAt(2, "Elena");
        System.out.println("e was added at position 2?" + list.toString());

        list.insertAt(2, "Juan");
        System.out.println("A was added at position 2?" + list.toString());


        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
//		list.removeFirst();
//		list.removeLast();
        System.out.println("after remove first and last?"+list.toString());

        //list.removeAll("Ana");
        System.out.println("all C were removed?" + list.toString());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());


        System.out.println("Size: " + list.getSize());

        for (int i=0; i<list.getSize();i++) {
            System.out.println("Element at position " + i + ":"+ list.getAt(i));
        }



        list.insertAt(5, "FRan");
        list.insertAt(0, "German");

        int pos=list.getSize()+5;
        list.insertAt(pos, "Zoe");
        list.insertAt(pos+1, "Zoe");


        System.out.println(list.toString());


        list.removeAll("Juan");

        System.out.println("contains Juan?" + list.contains("Juan"));
        System.out.println("contains Zoe?" + list.contains("Zoe"));

        System.out.println("isEmpty?" + list.isEmpty());

        System.out.println("index of Bele" + list.getIndexOf("Belen"));
        System.out.println("index of Pilar" + list.getIndexOf("Pilar"));

        list.removeAt(5);
        System.out.println("removed element at position 5"+list.toString());

        list=new DList();

        System.out.println(list.toString());
        list.sort2();
        System.out.println(list.toString());

        list.addFirst("Juan");

        list.sort2();
        System.out.println(list.toString());


    }
}
