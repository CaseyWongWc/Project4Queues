package project4deque;

public final class linkedDeque <T> implements dequeInterface<T>
{
    private DLNode firstNode;
    private DLNode lastNode;

    public linkedDeque()
    {
        firstNode = null;
        lastNode = null;
    }

    /** */
    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    }
    public void clear()
    {
        firstNode = null;
        lastNode = null;
    }

    public void addToBack(T newEntry)
    {
        DLNode newNode = new DLNode(newEntry,lastNode,null);

        if(isEmpty())
        {
            firstNode = newNode;
        }
        else
        {
            lastNode.setNext(newNode);
        }

        lastNode = newNode;
    }

    public void addToFront(T newEntry)
    {
        DLNode newNode = new DLNode(newEntry,null,firstNode);
        if (isEmpty())
        {
            lastNode = newNode;
        }
        else
        {
            firstNode.setPrevious(newNode);
        }
            firstNode = newNode;
    }

    public T removeFront()
    {
        //if (isEmpty()) { // Check if the deque is empty before attempting to remove
       //     return null; // Or throw an appropriate exception or handle as needed
        //}

        T front = getFront();
        firstNode = firstNode.getNext();

        if (firstNode == null)
        {
            lastNode = null;
        }
        else
        {
            firstNode.setPrevious(null);
        }
        return front;
    }

    public T removeBack()
    {
        //if (isEmpty()) { // Check if the deque is empty before attempting to remove
       //     return null; // Or throw an appropriate exception or handle as needed
       // }
        
        T back = getBack();
        lastNode = lastNode.getPrevious();

        if (lastNode == null)
        {    
            firstNode = null;
        }
        else
        {
            //lastNode = lastNode.getPrevious();
            lastNode.setNext(null);
        }

        return back;
    }
    public T getFront()
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            return firstNode.getData();
        }
    }

    public T getBack()
    {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            return lastNode.getData();
        }
    }


    





    private class DLNode
    {
        private T data; //Deque entry
        private DLNode next; //Link to next node
        private DLNode previous; // Link to previous node
        
        private DLNode(T dataPortion)
        {
            data = dataPortion;
            next = null;
            previous = null;
        }
    
        private DLNode(T dataPortion, DLNode nextPortion,DLNode previousPortion)
        {
            data = dataPortion;
            next = nextPortion;
            previous = previousPortion;
        }

        public T getData() 
        {
            return data;
        }
        public void setData(T newData) 
        {
            data = newData;
        }
        public DLNode getNext() 
        {
            return next;
        }
        public void setNext(DLNode nextNode) 
        {
            next = nextNode;
        }
        public DLNode getPrevious() 
        {
            return previous;
        }
        public void setPrevious(DLNode previousNode) 
        {
            previous = previousNode;
        }
    }
    
}
