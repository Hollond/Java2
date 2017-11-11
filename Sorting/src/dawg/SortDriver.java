package dawg;


import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 
 * @author Jason Poepke
 * @date November 5th, 2017
 * @class CSci 2002
 * 
 * @description 	The program is designed to show how 6 different styles of sorting can be used on the same data and that the have varying times to do the respective sort
 * 
 *  
 *
 */

public class SortDriver 	//driver class
{

	
    public static void main(String[] args) throws IOException
    {
        //System.out.println("Umm");
        RunProcessing now = new RunProcessing();
        now.runned();

        SortProcessing sort = new SortProcessing(now.Spyer);
        sort.sorted();
        
        

    }

}

class RunProcessing	//processing class
{
    Spy Spyer = new Spy();
    FileIO Reading = new FileIO();
    legend legend = new legend();

    void runned() throws IOException
    {
        Reading.reader(Spyer);
        Spyer.Date.repairAll();	//string data type
        Spyer.AdjustedClose.repairAll();	//float data type
        Spyer.Volume.repairAll();	//this is has Long int data type

        Spyer.printer();
        //legend.display();
    }
}

class SortProcessing	//allows the processing of the sort methods to start
{
    Spy SpyerSelectionSort;
    Spy SpyerInsertionSort;
    Spy SpyerShellSort;
    Spy SpyerMergeSort;
    Spy SpyerQuickSort;
    Spy SpyerRadixSort;
    SortProcessing(Spy Spied){
        SpyerSelectionSort = new Spy(Spied);
        SpyerInsertionSort = new Spy(Spied);
        SpyerShellSort = new Spy(Spied);
        SpyerMergeSort = new Spy(Spied);
        SpyerQuickSort = new Spy(Spied);
        SpyerRadixSort = new Spy(Spied);
    }
    FileIO Writing = new FileIO();
    legend legend = new legend();
    SortMethods<?> sort = new SortMethods<>();

    void sorted() throws IOException //calls the sort methods one at a time
    {
        //ArrayList<Long> billy = new ArrayList<>( Spyer.Volume.elements);
        System.out.println("---Unprocessed");
        System.out.println(SpyerSelectionSort.Volume.elements);
        System.out.println("--------------");

        sort.startTimer();
        System.out.println("---Selection Sort");
        sort.SelectionSort(SpyerSelectionSort.Volume.elements, SpyerSelectionSort.Date.elements, SpyerSelectionSort.AdjustedClose.elements);
        sort.endTimer();
        legend.printArray(SpyerSelectionSort.Volume.elements, SpyerSelectionSort.Date.elements, SpyerSelectionSort.AdjustedClose.elements);
        System.out.println("Elements processed: " + sort.getProcessedElements() + " Comparisons made: " + sort.getComparisons() + " time: " + sort.getTime() + "ms");
        System.out.println("--------------");
        Writing.writer(SpyerSelectionSort, "SPY_Selection_sorted.csv");
        sort.clean();

        sort.startTimer();
        System.out.println("---Insertion Sort");
        sort.InsertionSort(SpyerInsertionSort.Volume.elements, SpyerInsertionSort.Date.elements, SpyerInsertionSort.AdjustedClose.elements);
        sort.endTimer();
        legend.printArray(SpyerInsertionSort.Volume.elements, SpyerInsertionSort.Date.elements, SpyerInsertionSort.AdjustedClose.elements);
        System.out.println("Elements processed: " + sort.getProcessedElements() + " Comparisons made: " + sort.getComparisons() + " time: " + sort.getTime() + "ms");
        System.out.println("--------------");
        Writing.writer(SpyerInsertionSort, "SPY_Insertion_sorted.csv");
        sort.clean();

        sort.startTimer();
        System.out.println("---Shell Sort");
        sort.ShellSort(SpyerShellSort.Volume.elements, SpyerShellSort.Date.elements, SpyerShellSort.AdjustedClose.elements);
        sort.endTimer();
        legend.printArray(SpyerShellSort.Volume.elements, SpyerShellSort.Date.elements, SpyerShellSort.AdjustedClose.elements);
        System.out.println("Elements processed: " + sort.getProcessedElements() + " Comparisons made: " + sort.getComparisons() + " time: " + sort.getTime() + "ms");
        System.out.println("--------------");
        Writing.writer(SpyerShellSort, "SPY_Shell_sorted.csv");
        sort.clean();

        sort.startTimer();
        System.out.println("---Merge Sort");
        sort.MergeSort(SpyerMergeSort.Volume.elements, SpyerMergeSort.Date.elements, SpyerMergeSort.AdjustedClose.elements);
        sort.endTimer();
        legend.printArray(SpyerMergeSort.Volume.elements, SpyerMergeSort.Date.elements, SpyerMergeSort.AdjustedClose.elements);
        System.out.println("Elements processed: " + sort.getProcessedElements() + " Comparisons made: " + sort.getComparisons() + " time: " + sort.getTime() + "ms");
        System.out.println("--------------");
        Writing.writer(SpyerMergeSort, "SPY_Merge_sorted.csv");
        sort.clean();

        sort.startTimer();
        System.out.println("---Quick Sort");
        sort.QuickSort(SpyerQuickSort.Volume.elements, SpyerQuickSort.Date.elements, SpyerQuickSort.AdjustedClose.elements);
        sort.endTimer();
        legend.printArray(SpyerQuickSort.Volume.elements, SpyerQuickSort.Date.elements, SpyerQuickSort.AdjustedClose.elements);
        System.out.println("Elements processed: " + sort.getProcessedElements() + " Comparisons made: " + sort.getComparisons() + " time: " + sort.getTime() + "ms");
        System.out.println("--------------");
        Writing.writer(SpyerQuickSort, "SPY_Quick_sorted.csv");
        sort.clean();

        sort.startTimer();
        System.out.println("---Radix Sort");
        sort.RadixSort(SpyerRadixSort.Volume.elements, SpyerRadixSort.Date.elements, SpyerRadixSort.AdjustedClose.elements);
        sort.endTimer();
        legend.printArray(SpyerRadixSort.Volume.elements, SpyerRadixSort.Date.elements, SpyerRadixSort.AdjustedClose.elements);
        System.out.println("Elements processed: " + sort.getProcessedElements() + " Comparisons made: " + sort.getComparisons() + " time: " + sort.getTime() + "ms");
        System.out.println("--------------");
        Writing.writer(SpyerRadixSort, "SPY_Radix_sorted.csv");
        sort.clean();
    }
    
    
}

class Spy	//used to separates the values gained from the file spy.csv into proper categories 
{

    public PreProcess<String> Date = new PreProcess<String>("String");
    public PreProcess<Long> Volume = new PreProcess<Long>((long) 1);
    public PreProcess<Float> AdjustedClose = new PreProcess<Float>((float)1.0);
    public Spy(){};

    public Spy(Spy DeepSpy){
        Date = new PreProcess<String>(DeepSpy.Date);
        Volume = new PreProcess<Long>(DeepSpy.Volume);
        AdjustedClose = new PreProcess<Float>(DeepSpy.AdjustedClose);
        //spySet();
        //System.out.println("set public");
    };

    public void printer()	// prints the data for each of the three required columns
    {
        int length1 = Date.elements.size();
        int length2 = Volume.elements.size();
        int length3 = AdjustedClose.elements.size();
        for(int j = 0; (j < length1) && (j<length2) && (j<length3); j++ ){
            System.out.print(Date.elements.get(j) + "\t");
            System.out.print(Volume.elements.get(j) + "\t");
            System.out.print(AdjustedClose.elements.get(j) + "\t");
            System.out.println();
        }
    }

}

class PreProcess<T extends Comparable<? super T>> 	// class to fix missing or erroneous data
{
    //T[] elements;
    ArrayList<T> elements = new ArrayList<T>();
    T type;
    int end;
    int x = 0;

    PreProcess(T Type)
    {
        type = Type;
    }

    PreProcess(PreProcess<T> Processed)	// constructor to allow data to be rapaired
    {
        elements = new ArrayList<T>(Processed.elements);
    }

    public void insert(T obj)	//adds the missing value to the array
    {
        elements.add( (T) obj );
    }

    public void repairAll()	// repairs all missing or erroneous data
    {
        end = elements.size();
        //System.out.println("help");
        for(int i  = end; i >= 0; i--)
        {
            repair(i);
            //System.out.println("help");
        }
    }

    public void repair(int placement)	// driver class for repair methods
    {
        //System.out.println(placement);
        Long Longer = (long) 1.0;
        Float floater = (float)1.0;
        String stringer = "String";
        end = elements.size()-1;
        if(placement > end)
        {

        } else if( type.equals(stringer) )
        {
            repair(stringer, placement);
        } else if( type.equals(Longer) )
        {
            repair(Longer, placement);
        }else if( type.equals(floater) )
        {
            repair(floater, placement);
        }
    }

    public void repair(String checker, int placement)	//repairs missing data for string
    {
        if(!type.getClass( ).equals( elements.get(placement).getClass() ) )
        {
            if(placement>0)
            {
                repair(placement-1);
                elements.set(placement, elements.get(placement-1));
            } else
            {
                repair(placement+1);
                elements.set(placement, elements.get(placement+1));
            }
        } else if( elements.get(placement).equals("") )
        {
            if(placement>0)
            {
                repair(placement-1);
                elements.set(placement, elements.get(placement-1));
            } else
            {
                repair(placement+1);
                elements.set(placement, elements.get(placement+1));
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void repair(Long checker, int placement)	//fixes erroneous data for long data type
    {
        if(elements.get(placement) == null)
        {
            if(placement == end)
            {
                repair(placement-1);
                repair(placement-2);
                elements.set(placement, (T) Long.valueOf( 2*(Long)elements.get(placement-1)-(Long)elements.get(placement-2)) );
            } else if(placement>0)
            {
                repair(placement-1);
                repair(placement+1);
                elements.set(placement, (T) Long.valueOf( ((Long)elements.get(placement-1)+(Long)elements.get(placement+1))/(long)2.0) );
            } else
            {
                x++;
                repair(placement+x);
                repair(placement+1+x);
                elements.set(placement, (T) Long.valueOf( 2*((Long)elements.get(placement+x))-(Long)elements.get(placement+x+1) ) );
            }
        }
        else if( Double.isNaN((Long) elements.get(placement)) )
        {
            if(placement==end){
                repair(placement-1);
                repair(placement-2);
                elements.set(placement, (T) Long.valueOf( 2*(Long)elements.get(placement-1)-(Long)elements.get(placement-2)) );
            } else if(placement>0)
            {
                repair(placement-1);
                repair(placement+1);
                elements.set(placement, (T) Long.valueOf( ((Long)elements.get(placement-1)+(Long)elements.get(placement+1))/(long)2.0) );
            } else
            {
                x++;
                repair(placement+x);
                repair(placement+1+x);
                elements.set(placement, (T) Long.valueOf( 2*((Long)elements.get(placement+x))-(Long)elements.get(placement+x+1) ) );
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void repair(Float checker, int placement)	//fixes erroneous data for float
    {
        if(!type.getClass( ).equals( elements.get(placement).getClass() ) )
        {
            if(placement==end){
                repair(placement-1);
                repair(placement-2);
                elements.set(placement, (T) Float.valueOf( 2*(Float)elements.get(placement-1)-(Float)elements.get(placement-2)) );
            } else if(placement>0)
            {
                repair(placement-1);
                repair(placement+1);
                elements.set(placement, (T) Float.valueOf( ((Float)elements.get(placement-1)+(Float)elements.get(placement+1))/(float)2.0) );
            } else
            {
                x++;
                repair(placement+x);
                repair(placement+1+x);
                elements.set(placement, (T) Float.valueOf( 2*((Float)elements.get(placement+x))-(Float)elements.get(placement+x+1) ) );
            }
        } 
        else if( Float.isNaN((Float) elements.get(placement)) )
        {	
            if(placement==end){
                repair(placement-1);
                repair(placement-2);
                elements.set(placement, (T) Float.valueOf( 2*(Float)elements.get(placement-1)-(Float)elements.get(placement-2)) );
            } else if(placement>0)
            {
                repair(placement-1);
                repair(placement+1);
                elements.set(placement, (T) Float.valueOf( ((Float)elements.get(placement-1)+(Float)elements.get(placement+1))/(float)2.0) );
            } else
            {
                x++;
                repair(placement+x);
                repair(placement+1+x);
                elements.set(placement, (T) Float.valueOf( 2*((Float)elements.get(placement+x))-(Float)elements.get(placement+x+1) ) );
            }
        }
    }
}

class legend //explains the sort mehtods
{
	public void display()	//displays what the sort method is and what is does
	{
		String selection = "Selection sort: Select min (max) for first position n; swapping elements; increment first position. Used on small arrays ~= 20-30 elements in size. Best case Small arrays O(n^2), worst case big arrays O(n^2)";
		String insertion = "Insertion sort: Find a place for a new element in an already sorted list that maintains the order. Used when the data is nearly sorted or on small data. Best case sorted data O(n), worst case not sorted O(n^2)";
		String shell = "Shell sort: With equal spacing between N sub-arrays, sort the sub-arrays by insertion sort. Used when data nearly sorted. Best case sorted data O(n), worst case not sorted O(n^2)";
		String merge = "Merge sort: Starting with n sublists of 1 element each, merge the sublists in order. Used for linked list type data. Best case linked list O(nLog(n)), worst case array O(nLog(n))";
		String quick = "Quick sort: Like merge sort in that recursive calls halve the list, in-place sort. Used for array type data. Best case array list O(nLog(n)), worst case linked list O(n^2)";
		String radix = "Radix sort: uses buckets for each category represented by the items being sorted. Used for keys in integer representation order. Best case integer sort O(n), worst case O(n)";
		
		System.out.println(selection);
		System.out.println(insertion);
		System.out.println(shell);
		System.out.println(merge);
		System.out.println(quick);
		System.out.println(radix);
	}
	public <L, K> void printArray(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2)
	{
		System.out.println(elements.toString());
        System.out.println(relativeElements1.toString());
        System.out.println(relativeElements2.toString());
	}
}

class FileIO {
    public void reader(Spy obj) throws IOException	// reads the required file to be sorted into the program
    {
        try
        {
            @SuppressWarnings("resource")
            //BufferedReader spy = new BufferedReader(new FileReader("Erraneous_SPY.csv")); //reads file
            BufferedReader spy = new BufferedReader(new FileReader("SPY.csv")); //reads file
            String reading;  //string to store file
            int n = 0;
            while((reading = spy.readLine()) != null && n >= 0)  //reads file into string
            {
                String[] fields = reading.split(",",7);  //stores file separated into an array.
                //if(n%50==0){
                //	String list = (String)fields[0] + "\t";
                //	System.out.print(list);
                //}
                if(fields[0]!=null){
                    obj.Date.insert(fields[0]);
                } else{
                    obj.Date.insert("");
                }
                if(fields[5]!=null && !fields[5].equals("")){
                    obj.Volume.insert( Long.parseLong(fields[5]) );
                    //obj.price.insert( (float) 0.0 );
                } else{
                    //obj.Volume.insert( Long.NaN );
                    obj.Volume.insert( null );  //this doesn't work...
                }
                if(fields[6] !=null && !fields[6].equals(""))
                {
                    obj.AdjustedClose.insert(Float.parseFloat(fields[6]));
                } else{
                    obj.AdjustedClose.insert(Float.NaN);
                }

                //n++;
            }
        }
        finally{}
    }

    public void writer(Spy obj, String filename) throws IOException	//fileIO file writer
    {
        BufferedWriter br = new BufferedWriter(new FileWriter(filename));
        int length1 = obj.Date.elements.size();
        int length2 = obj.Volume.elements.size();
        int length3 = obj.AdjustedClose.elements.size();
        for(int j = 0; (j < length1) && (j<length2) && (j<length3); j++ )
        {
            //System.out.print(obj.Date.elements.get(j) + ", ");
            //System.out.print(obj.Volume.elements.get(j) + ", ");
            //System.out.print(obj.AdjustedClose.elements.get(j));
            //System.out.println();
            
            br.write(obj.Date.elements.get(j) + ", ");
            br.write(obj.Volume.elements.get(j) + ", ");
            br.write("" + obj.AdjustedClose.elements.get(j));
            br.write("\n");
        }
        
    }
}

class Efficiency // gathers how effecient the sort methods are in time taken 
{

    Long startTime;
    Long estimatedTime;

    public void start()	//starts the clock on sort method
    {
        startTime = System.nanoTime();
    }

    public void stop()	//stops the clock on the sort method
    {
        estimatedTime = System.nanoTime() - startTime;
    }

    public Long getTime()	// returns the total time the sort method takes
    {
        return (long) ((long) estimatedTime/(1.0e6));
    }
}

class SortMethods<T extends Comparable<? super T>>
{	

    long comparisons = 0;
    int processedElements = 0;
    Efficiency timer;

    public <L,K> void SelectionSort(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2)	
    {
        int j =  elements.size();
        processedElements = (int) j;
        for (int i = 0; i < j; i++) 
        {

            int pos = i;
            int swapPos = i;
            Long min;
            for(int t = i; t < j; t++)
            {
                //System.out.println(elements.get(t).compareTo(elements.get(pos)));
                //if ( elements.get(t).compareTo( elements.get(swapPos) ) < 0 ){
                //	swapPos = t;
                //	System.out.println(t);
                //}
                if ( elements.get(t) < elements.get(swapPos) )
                {
                    swapPos = t;
                    //System.out.println(t);
                }
                comparisons++;
            }

            min = elements.get(swapPos);
            //System.out.println("Swapping: " + min + " for " + elements.get(pos));
            elements.set(swapPos, elements.get(pos));
            elements.set(pos, min);
            //System.out.println("Swapped: " + elements.get(pos) + " and " + elements.get(swapPos));

            //--sort elements with Long
            L jim = relativeElements1.get(swapPos);
            relativeElements1.set(swapPos, relativeElements1.get(pos));
            relativeElements1.set(pos, jim);
            K bean = relativeElements2.get(swapPos);
            relativeElements2.set(swapPos, relativeElements2.get(pos));
            relativeElements2.set(pos, bean);
            //--end sort

            //          T tmpObj = objects[index2];
            //        	objects[index2] = objects[index1];
            //        	objects[index1] = tmpObj;

        }
       
    }

    public <L,K> void SelectionSort(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2, boolean SuppressOutput)	//sorts based on a swap method
    {				
        int j =  elements.size();
        processedElements = j;

        for (int i = 0; i < j; i++) 
        {

            int pos = i;
            int swapPos = i;
            Long min;
            for(int t = i; t < j; t++)
            {
                if ( elements.get(t) < elements.get(swapPos) )
                {
                    swapPos = t;
                }
                comparisons++;
            }

            min = elements.get(swapPos);
            //System.out.println("Swapping: " + min + " for " + elements.get(pos));
            elements.set(swapPos, elements.get(pos));
            elements.set(pos, min);
            //System.out.println("Swapped: " + elements.get(pos) + " and " + elements.get(swapPos));

            //--sort elements with Long
            L jim = relativeElements1.get(swapPos);
            relativeElements1.set(swapPos, relativeElements1.get(pos));
            relativeElements1.set(pos, jim);
            K bean = relativeElements2.get(swapPos);
            relativeElements2.set(swapPos, relativeElements2.get(pos));
            relativeElements2.set(pos, bean);
            //--end sort

        }
    }

	
    public <L,K> void InsertionSort(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2)	//inserts the value into the correct 
    {																															// plave on the array
        int i =0;
        Long key;
        int t = elements.size(); 
        processedElements = t;

        for ( int j = 1; j < t; j++ )
        {
            key = elements.get(j);
            i = j - 1;

            while ( i >= 0 && key < elements.get(i) ) 
            {
                Long element= elements.get(i+1);             //here
                elements.set(i+1,elements.get(i));          //here
                elements.set(i,element);                      //here

                L relativeElement1= relativeElements1.get(i+1);             //here
                relativeElements1.set(i+1,relativeElements1.get(i));          //here
                relativeElements1.set(i,relativeElement1); 

                K relativeElement2= relativeElements2.get(i+1);             //here
                relativeElements2.set(i+1,relativeElements2.get(i));          //here
                relativeElements2.set(i,relativeElement2);

                i--;
                comparisons++;
            } 
        }
        key=elements.get(i+1);
        
    }

    public <L, K> void ShellSort(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2)	// sorts the array with a shell sort.
    {																												// sorts the array based on intervals
        int hash;
        int outist;
        Long temp;

        int space = 1;
        int t = elements.size();
        processedElements = t;

        while(space <= elements.size()/3)
        {

            space = space * 3 + 1;
        }
        while(space > 0){
            for(outist = space; outist < t; outist++)
            {
                temp = elements.get( outist);
                L rel1temp = relativeElements1.get( outist);
                K rel2temp = relativeElements2.get( outist);

                hash = outist;

                while(hash > space - 1 && elements.get((hash - space)) >= temp)
                {
                    elements.set(hash, elements.get(hash - space));

                    relativeElements1.set(hash, relativeElements1.get(hash - space));

                    relativeElements2.set(hash, relativeElements2.get(hash - space));
                    hash -= space;
                    comparisons++;
                }
                elements.set(hash, temp);

                relativeElements1.set(hash, rel1temp);

                relativeElements2.set(hash, rel2temp);
            }
            space = space / 3;
        }
        
    }

    public <L, K> void MergeSort(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2)	//initiates the merge sort
    {
        processedElements = elements.size();
    	MergeSort(new packet<L, K>(elements, relativeElements1, relativeElements2));
    }

    public <L, K> void MergeSort(packet<L, K> merge)	// driver of the merge sort method
    {
        if(merge.elements.size() > 1)
        {
            packet<L, K> left = leftsort(merge);
            packet<L, K> right = rightsort(merge);

            MergeSort(left);
            MergeSort(right);

            merger(merge, left, right);
        }
    }

    public <L, K> packet<L, K> leftsort(packet<L, K> merge)	//handles the left half of the array elements
    {
        int size1 = merge.elements.size()/2;
        packet<L, K> left = new packet<L, K>();
        for (int i = 0; i < size1; i++) {
            left.elements.add(merge.elements.get(i));
            left.relativeElements1.add(merge.relativeElements1.get(i));
            left.relativeElements2.add(merge.relativeElements2.get(i));
        }
        return left;
    }

    public <L, K> packet<L, K> rightsort(packet<L, K> merge)	//handles the right half of the array elements
    {
        int size1 = merge.elements.size() / 2;
        int size2 = merge.elements.size() - size1;
        packet<L, K> right = new packet<L, K>();
        for (int i = 0; i < size2; i++) {
            right.elements.add(merge.elements.get(i+size1));
            right.relativeElements1.add(merge.relativeElements1.get(i+size1));
            right.relativeElements2.add(merge.relativeElements2.get(i+size1));
        }
        return right;
    }

    public <L, K> void merger(packet<L, K> merge, packet<L, K> left, packet<L, K> right)	// sort part for the merge sort method. checks the values to place them in 
    																						// 	back into array based of value 
    {
        int i1 = 0;  
        int i2 = 0; 

        for (int i = 0; i < merge.elements.size(); i++) {
            if (i2 >= right.elements.size() || (i1 < left.elements.size() && left.elements.get(i1) <= right.elements.get(i2))) {
                merge.elements.set(i, left.elements.get(i1));
                merge.relativeElements1.set(i, left.relativeElements1.get(i1));
                merge.relativeElements2.set(i, left.relativeElements2.get(i1));
                i1++;
            } else {
                merge.elements.set(i, right.elements.get(i2)); 
                merge.relativeElements1.set(i, right.relativeElements1.get(i2));
                merge.relativeElements2.set(i, right.relativeElements2.get(i2));
                i2++;
            }
            comparisons++;
        }
    }

	
    public <L, K> void QuickSort(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2)	// clears the quick sort array method
    {
        processedElements = elements.size();
        packet<L,K> sortedQuick = QuickSort(new packet<L, K>(elements, relativeElements1, relativeElements2));
        //elements.removeAll(elements);
        elements.clear();
        elements.addAll(sortedQuick.elements);
        //relativeElements1.removeAll(relativeElements1);
        relativeElements1.clear();
        relativeElements1.addAll(sortedQuick.relativeElements1);
        //relativeElements2.removeAll(relativeElements2);
        relativeElements2.clear();
        relativeElements2.addAll(sortedQuick.relativeElements2);
        //System.out.println(elements.toString());
        //System.out.println(relativeElements1.toString());
        //System.out.println(relativeElements2.toString());
    }

    public <L, K> packet<L, K> QuickSort(packet<L, K> packed)	//quick sort method, sorts the array by breaking it into smaller manageable arrays
    {

        int t = packed.elements.size();
        //if(packed.elements.size() <= 10)
        //{
        //	SelectionSort(packed.elements, packed.relativeElements1, packed.relativeElements2, true);
        //	return packed;
        //}
        if(packed.elements.size() <= 1)
        {
            //SelectionSort(packed.elements, packed.relativeElements1, packed.relativeElements2, true);
            return packed;
        }

        int middle = (packed.elements.size()/2);
        Long pivot = packed.elements.get(middle);
        L pivotRel1 = packed.relativeElements1.get(middle);
        K pivotRel2 = packed.relativeElements2.get(middle);

        packet<L, K> ReturnedPacketLess;
        packet<L, K> ReturnedPacketGreater;
        packet<L, K> ReturnPacketMerged;
        //
        ArrayList<Long> less = new ArrayList<Long>();
        ArrayList<Long> greater = new ArrayList<Long>();
        ArrayList<Long> merged = new ArrayList<Long>();
        //
        ArrayList<L> lessRel1 = new ArrayList<L>();
        ArrayList<L> greaterRel1 = new ArrayList<L>();
        ArrayList<L> mergedRel1 = new ArrayList<L>();
        //
        ArrayList<K> lessRel2 = new ArrayList<K>();
        ArrayList<K> greaterRel2 = new ArrayList<K>();
        ArrayList<K> mergedRel2 = new ArrayList<K>();

        for (int i = 0; i < t; i++) {
            if( i == middle ){
            } else{
                if(packed.elements.get(i) <= pivot){
                    less.add(packed.elements.get(i));
                    lessRel1.add(packed.relativeElements1.get(i));
                    lessRel2.add(packed.relativeElements2.get(i));
                } else{
                    greater.add(packed.elements.get(i));
                    greaterRel1.add(packed.relativeElements1.get(i));
                    greaterRel2.add(packed.relativeElements2.get(i));
                }
                comparisons++;
            }
        }
        ReturnedPacketLess = QuickSort(new packet<L, K>(less,lessRel1,lessRel2));
        ReturnedPacketGreater = QuickSort(new packet<L,K>(greater,greaterRel1,greaterRel2));

        merged.addAll(ReturnedPacketLess.elements);
        merged.add(pivot);
        merged.addAll(ReturnedPacketGreater.elements);

        mergedRel1.addAll(ReturnedPacketLess.relativeElements1);
        mergedRel1.add(pivotRel1);
        mergedRel1.addAll(ReturnedPacketGreater.relativeElements1);

        mergedRel2.addAll(ReturnedPacketLess.relativeElements2);
        mergedRel2.add(pivotRel2);
        mergedRel2.addAll(ReturnedPacketGreater.relativeElements2);

        ReturnPacketMerged = new packet<L,K>(merged,mergedRel1, mergedRel2);
        return ReturnPacketMerged;
    }

    public <L, K> void RadixSort(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2)	//driver class of the radi sort method
    {
        int length = elements.size();
        processedElements = length;
        //buckets<L,K> phill =  new buckets<L,K>(elements, relativeElements1, relativeElements2);
        buckets<L,K> phill = RadixSort( new buckets<L,K>(elements, relativeElements1, relativeElements2),(long) 1 );
        //phill = RadixSort( phill,(long) 1 );
        phill.emptyBuckets();
        //elements.removeAll(elements);
        elements.clear();
        elements.addAll(phill.bucketPad);
        //relativeElements1.removeAll(relativeElements1);
        relativeElements1.clear();
        relativeElements1.addAll(phill.rel1bucketPad);
        //relativeElements2.removeAll(relativeElements2);
        relativeElements2.clear();
        relativeElements2.addAll(phill.rel2bucketPad);
        //System.out.println(elements.toString());
        //System.out.println(relativeElements1.toString());
        //System.out.println(relativeElements2.toString());
    }

    public <L, K> buckets<L, K> RadixSort(buckets<L, K> empty, Long Tens)	//initiates the radix sort method
    {
    	//System.out.println("Help");
    	if(empty.bucketSize() == 0 && Tens > 1){
    		//System.out.println("End");
        	return empty;
        }
    	empty.emptyBuckets();
    	//buckets<L,K> phill = new buckets<L,K>( RadixSorter(empty.bucketPad, empty.rel1bucketPad, empty.rel2bucketPad, Tens) );
        return RadixSorter(empty.bucketPad, empty.rel1bucketPad, empty.rel2bucketPad, Tens);
    }

    public <L, K> buckets<L, K> RadixSorter(ArrayList<Long> elements, ArrayList<L> relativeElements1, ArrayList<K> relativeElements2, Long Tens)	//"sorts" the elements in the array with radix
    {
        //System.out.println("help");
    	//System.out.println(elements.toString());
        //System.out.println(relativeElements1.toString());
        //System.out.println(relativeElements2.toString());
    	int length = elements.size();
        if(length == 0){
            return new buckets<L, K>();
        }
        buckets<L,K> phill = new buckets<L,K>();
        //buckets<L,K> returnPhull = new buckets<L,K>();
        for(int i = 0; i < length; i++)
        {
        	if((elements.get(i)<Tens) || (elements.get(i)<0))
            {
                phill.bucketPad.add(elements.get(i));
                phill.rel1bucketPad.add(relativeElements1.get(i));
                phill.rel2bucketPad.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 0)
            {
                phill.bucket0.add(elements.get(i));
                phill.rel1bucket0.add(relativeElements1.get(i));
                phill.rel2bucket0.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 1)
            {
                phill.bucket1.add(elements.get(i));
                phill.rel1bucket1.add(relativeElements1.get(i));
                phill.rel2bucket1.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 2)
            {
                phill.bucket2.add(elements.get(i));
                phill.rel1bucket2.add(relativeElements1.get(i));
                phill.rel2bucket2.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 3)
            {
                phill.bucket3.add(elements.get(i));
                phill.rel1bucket3.add(relativeElements1.get(i));
                phill.rel2bucket3.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 4)
            {
                phill.bucket4.add(elements.get(i));
                phill.rel1bucket4.add(relativeElements1.get(i));
                phill.rel2bucket4.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 5)
            {
                phill.bucket5.add(elements.get(i));
                phill.rel1bucket5.add(relativeElements1.get(i));
                phill.rel2bucket5.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 6)
            {
                phill.bucket6.add(elements.get(i));
                phill.rel1bucket6.add(relativeElements1.get(i));
                phill.rel2bucket6.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 7)
            {
                phill.bucket7.add(elements.get(i));
                phill.rel1bucket7.add(relativeElements1.get(i));
                phill.rel2bucket7.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 8)
            {
                phill.bucket8.add(elements.get(i));
                phill.rel1bucket8.add(relativeElements1.get(i));
                phill.rel2bucket8.add(relativeElements2.get(i));
            } else if((elements.get(i)/Tens)%10 == 9)
            {
                phill.bucket9.add(elements.get(i));
                phill.rel1bucket9.add(relativeElements1.get(i));
                phill.rel2bucket9.add(relativeElements2.get(i));
            } else
            {
                //phill.bucketPad.add(elements.get(i));
                //phill.rel1bucketPad.add(relativeElements1.get(i));
                //phill.rel2bucketPad.add(relativeElements2.get(i));
            }
            comparisons++;
        }
        //returnPhull.addToBuckets( RadixSort(phill, (Tens*10)) );
        return RadixSort(phill, (Tens*10));
    }

    public void printer(){	}

    public void startTimer()	// starts the timer on the sort method
    {
        timer = new Efficiency();
        timer.start();
    }

    public void endTimer()	//ends recording of time for each sort
    {
        timer.stop();
    }

    public Long getTime()	//gets the time taken to for each sort
    {
        return timer.getTime();
    }

    public Long getComparisons()	//returns the number of comparisons
    {
        return comparisons;
    }

    public int getProcessedElements()	//returns the number of elements counted 
    {
        return processedElements;
    }

    public void clean()	//clean method for the count parameters
    {
        comparisons = 0;
        processedElements = 0;
    }
}

class packet<L, K>	//object that is passed to the required sort method
{
    ArrayList<Long> elements; 
    ArrayList<L> relativeElements1; 
    ArrayList<K> relativeElements2;
    packet(ArrayList<Long> Elements, ArrayList<L> RelativeElements1, ArrayList<K> RelativeElements2)
    {
        elements = Elements;
        relativeElements1 = RelativeElements1; 
        relativeElements2 = RelativeElements2;
    }

    packet()
    {
        elements = new ArrayList<Long>();
        relativeElements1 = new ArrayList<L>(); 
        relativeElements2 = new ArrayList<K>();
    }
}

class buckets<L, K>	//buckets used for the Radix sort method
{
    ArrayList<Long> bucket1;
    ArrayList<Long> bucket2;
    ArrayList<Long> bucket3;
    ArrayList<Long> bucket4;
    ArrayList<Long> bucket5;
    ArrayList<Long> bucket6;
    ArrayList<Long> bucket7;
    ArrayList<Long> bucket8;
    ArrayList<Long> bucket9;
    ArrayList<Long> bucket0;
    ArrayList<Long> bucketPad;

    ArrayList<L> rel1bucket1;
    ArrayList<L> rel1bucket2;
    ArrayList<L> rel1bucket3;
    ArrayList<L> rel1bucket4;
    ArrayList<L> rel1bucket5;
    ArrayList<L> rel1bucket6;
    ArrayList<L> rel1bucket7;
    ArrayList<L> rel1bucket8;
    ArrayList<L> rel1bucket9;
    ArrayList<L> rel1bucket0;
    ArrayList<L> rel1bucketPad;

    ArrayList<K> rel2bucket1;
    ArrayList<K> rel2bucket2;
    ArrayList<K> rel2bucket3;
    ArrayList<K> rel2bucket4;
    ArrayList<K> rel2bucket5;
    ArrayList<K> rel2bucket6;
    ArrayList<K> rel2bucket7;
    ArrayList<K> rel2bucket8;
    ArrayList<K> rel2bucket9;
    ArrayList<K> rel2bucket0;
    ArrayList<K> rel2bucketPad;

    buckets()	// initial constructor
    {	
        bucket1 = new ArrayList<Long>();
        bucket2 = new ArrayList<Long>();
        bucket3 = new ArrayList<Long>();
        bucket4 = new ArrayList<Long>();
        bucket5 = new ArrayList<Long>();
        bucket6 = new ArrayList<Long>();
        bucket7 = new ArrayList<Long>();
        bucket8 = new ArrayList<Long>();
        bucket9 = new ArrayList<Long>();
        bucket0 = new ArrayList<Long>();
        bucketPad = new ArrayList<Long>();

        rel1bucket1 = new ArrayList<L>();
        rel1bucket2 = new ArrayList<L>();
        rel1bucket3 = new ArrayList<L>();
        rel1bucket4 = new ArrayList<L>();
        rel1bucket5 = new ArrayList<L>();
        rel1bucket6 = new ArrayList<L>();
        rel1bucket7 = new ArrayList<L>();
        rel1bucket8 = new ArrayList<L>();
        rel1bucket9 = new ArrayList<L>();
        rel1bucket0 = new ArrayList<L>();
        rel1bucketPad = new ArrayList<L>();

        rel2bucket1 = new ArrayList<K>();
        rel2bucket2 = new ArrayList<K>();
        rel2bucket3 = new ArrayList<K>();
        rel2bucket4 = new ArrayList<K>();
        rel2bucket5 = new ArrayList<K>();
        rel2bucket6 = new ArrayList<K>();
        rel2bucket7 = new ArrayList<K>();
        rel2bucket8 = new ArrayList<K>();
        rel2bucket9 = new ArrayList<K>();
        rel2bucket0 = new ArrayList<K>();
        rel2bucketPad = new ArrayList<K>();
    }

    buckets(ArrayList<Long> emptyBucketPad, ArrayList<L> emptyRel1bucketPad, ArrayList<K> emptyRel2bucketPad)	//constuctor that is used to empty the buckets
    {
        bucket1 = new ArrayList<Long>();
        bucket2 = new ArrayList<Long>();
        bucket3 = new ArrayList<Long>();
        bucket4 = new ArrayList<Long>();
        bucket5 = new ArrayList<Long>();
        bucket6 = new ArrayList<Long>();
        bucket7 = new ArrayList<Long>();
        bucket8 = new ArrayList<Long>();
        bucket9 = new ArrayList<Long>();
        bucket0 = new ArrayList<Long>();
        bucketPad = new ArrayList<Long>(emptyBucketPad);

        rel1bucket1 = new ArrayList<L>();
        rel1bucket2 = new ArrayList<L>();
        rel1bucket3 = new ArrayList<L>();
        rel1bucket4 = new ArrayList<L>();
        rel1bucket5 = new ArrayList<L>();
        rel1bucket6 = new ArrayList<L>();
        rel1bucket7 = new ArrayList<L>();
        rel1bucket8 = new ArrayList<L>();
        rel1bucket9 = new ArrayList<L>();
        rel1bucket0 = new ArrayList<L>();
        rel1bucketPad = new ArrayList<L>(emptyRel1bucketPad);

        rel2bucket1 = new ArrayList<K>();
        rel2bucket2 = new ArrayList<K>();
        rel2bucket3 = new ArrayList<K>();
        rel2bucket4 = new ArrayList<K>();
        rel2bucket5 = new ArrayList<K>();
        rel2bucket6 = new ArrayList<K>();
        rel2bucket7 = new ArrayList<K>();
        rel2bucket8 = new ArrayList<K>();
        rel2bucket9 = new ArrayList<K>();
        rel2bucket0 = new ArrayList<K>();
        rel2bucketPad = new ArrayList<K>(emptyRel2bucketPad);
    }

    buckets(buckets<L, K> transfer)	// constructor for bucket class
    {	
        bucket1 = new ArrayList<Long>(transfer.bucket1);
        bucket2 = new ArrayList<Long>(transfer.bucket2);
        bucket3 = new ArrayList<Long>(transfer.bucket3);
        bucket4 = new ArrayList<Long>(transfer.bucket4);
        bucket5 = new ArrayList<Long>(transfer.bucket5);
        bucket6 = new ArrayList<Long>(transfer.bucket6);
        bucket7 = new ArrayList<Long>(transfer.bucket7);
        bucket8 = new ArrayList<Long>(transfer.bucket8);
        bucket9 = new ArrayList<Long>(transfer.bucket9);
        bucket0 = new ArrayList<Long>(transfer.bucket0);
        bucketPad = new ArrayList<Long>(transfer.bucketPad);

        rel1bucket1 = new ArrayList<L>(transfer.rel1bucket1);
        rel1bucket2 = new ArrayList<L>(transfer.rel1bucket2);
        rel1bucket3 = new ArrayList<L>(transfer.rel1bucket3);
        rel1bucket4 = new ArrayList<L>(transfer.rel1bucket4);
        rel1bucket5 = new ArrayList<L>(transfer.rel1bucket5);
        rel1bucket6 = new ArrayList<L>(transfer.rel1bucket6);
        rel1bucket7 = new ArrayList<L>(transfer.rel1bucket7);
        rel1bucket8 = new ArrayList<L>(transfer.rel1bucket8);
        rel1bucket9 = new ArrayList<L>(transfer.rel1bucket9);
        rel1bucket0 = new ArrayList<L>(transfer.rel1bucket0);
        rel1bucketPad = new ArrayList<L>(transfer.rel1bucketPad);

        rel2bucket1 = new ArrayList<K>(transfer.rel2bucket1);
        rel2bucket2 = new ArrayList<K>(transfer.rel2bucket2);
        rel2bucket3 = new ArrayList<K>(transfer.rel2bucket3);
        rel2bucket4 = new ArrayList<K>(transfer.rel2bucket4);
        rel2bucket5 = new ArrayList<K>(transfer.rel2bucket5);
        rel2bucket6 = new ArrayList<K>(transfer.rel2bucket6);
        rel2bucket7 = new ArrayList<K>(transfer.rel2bucket7);
        rel2bucket8 = new ArrayList<K>(transfer.rel2bucket8);
        rel2bucket9 = new ArrayList<K>(transfer.rel2bucket9);
        rel2bucket0 = new ArrayList<K>(transfer.rel2bucket0);
        rel2bucketPad = new ArrayList<K>(transfer.rel2bucketPad);
    }

    public void addToBuckets(buckets<L, K> empty)	//method for adding values to buckets
    {
        bucket1.addAll( empty.bucket1 );
        bucket2.addAll( empty.bucket2 );
        bucket3.addAll( empty.bucket3 );
        bucket4.addAll( empty.bucket4 );
        bucket5.addAll( empty.bucket5 );
        bucket6.addAll( empty.bucket6 );
        bucket7.addAll( empty.bucket7 );
        bucket8.addAll( empty.bucket8 );
        bucket9.addAll( empty.bucket9 );
        bucket0.addAll( empty.bucket0 );
        bucketPad.addAll( empty.bucketPad );

        rel1bucket1.addAll(empty.rel1bucket1);
        rel1bucket2.addAll(empty.rel1bucket2);
        rel1bucket3.addAll(empty.rel1bucket3);
        rel1bucket4.addAll(empty.rel1bucket4);
        rel1bucket5.addAll(empty.rel1bucket5);
        rel1bucket6.addAll(empty.rel1bucket6);
        rel1bucket7.addAll(empty.rel1bucket7);
        rel1bucket8.addAll(empty.rel1bucket8);
        rel1bucket9.addAll(empty.rel1bucket9);
        rel1bucket0.addAll(empty.rel1bucket0);
        rel1bucketPad.addAll(empty.rel1bucketPad);

        rel2bucket1.addAll(empty.rel2bucket1);
        rel2bucket2.addAll(empty.rel2bucket2);
        rel2bucket3.addAll(empty.rel2bucket3);
        rel2bucket4.addAll(empty.rel2bucket4);
        rel2bucket5.addAll(empty.rel2bucket5);
        rel2bucket6.addAll(empty.rel2bucket6);
        rel2bucket7.addAll(empty.rel2bucket7);
        rel2bucket8.addAll(empty.rel2bucket8);
        rel2bucket9.addAll(empty.rel2bucket9);
        rel2bucket0.addAll(empty.rel2bucket0);
        rel2bucketPad.addAll(empty.rel2bucketPad);
    }
    public long bucketSize()	//returns the size of the bucket
    {	
    	long size = 0;
    	size+=bucket0.size();
    	size+=bucket1.size();
    	size+=bucket2.size();
    	size+=bucket3.size();
    	size+=bucket4.size();
    	size+=bucket5.size();
    	size+=bucket6.size();
    	size+=bucket7.size();
    	size+=bucket8.size();
    	size+=bucket9.size();
    	return size;
    }
    
    public void emptyBuckets()	//empty method for the Radix buckets
    {
    	bucketPad.addAll( bucket0 );
    	bucketPad.addAll( bucket1 );
    	bucketPad.addAll( bucket2 );
    	bucketPad.addAll( bucket3 );
    	bucketPad.addAll( bucket4 );
    	bucketPad.addAll( bucket5 );
    	bucketPad.addAll( bucket6 );
    	bucketPad.addAll( bucket7 );
    	bucketPad.addAll( bucket8 );
    	bucketPad.addAll( bucket9 );
    	//bucket0.removeAll( bucket0 );
    	//bucket1.removeAll( bucket1 );
        //bucket2.removeAll( bucket2 );
        //bucket3.removeAll( bucket3 );
        //bucket4.removeAll( bucket4 );
        //bucket5.removeAll( bucket5 );
        //bucket6.removeAll( bucket6 );
        //bucket7.removeAll( bucket7 );
        //bucket8.removeAll( bucket8 );
        //bucket9.removeAll( bucket9 );
    	bucket0.clear();
    	bucket1.clear();
    	bucket2.clear();
    	bucket3.clear();
    	bucket4.clear();
    	bucket5.clear();
    	bucket6.clear();
    	bucket7.clear();
    	bucket8.clear();
    	bucket9.clear();
        
        

        rel1bucketPad.addAll(rel1bucket0);
        rel1bucketPad.addAll(rel1bucket1);
        rel1bucketPad.addAll(rel1bucket2);
        rel1bucketPad.addAll(rel1bucket3);
        rel1bucketPad.addAll(rel1bucket4);
        rel1bucketPad.addAll(rel1bucket5);
        rel1bucketPad.addAll(rel1bucket6);
        rel1bucketPad.addAll(rel1bucket7);
        rel1bucketPad.addAll(rel1bucket8);
        rel1bucketPad.addAll(rel1bucket9);
        //rel1bucket0.removeAll(rel1bucket0);
        //rel1bucket1.removeAll(rel1bucket1);
        //rel1bucket2.removeAll(rel1bucket2);
        //rel1bucket3.removeAll(rel1bucket3);
        //rel1bucket4.removeAll(rel1bucket4);
        //rel1bucket5.removeAll(rel1bucket5);
        //rel1bucket6.removeAll(rel1bucket6);
        //rel1bucket7.removeAll(rel1bucket7);
        //rel1bucket8.removeAll(rel1bucket8);
        //rel1bucket9.removeAll(rel1bucket9);
        rel1bucket0.clear();
        rel1bucket1.clear();
        rel1bucket2.clear();
        rel1bucket3.clear();
        rel1bucket4.clear();
        rel1bucket5.clear();
        rel1bucket6.clear();
        rel1bucket7.clear();
        rel1bucket8.clear();
        rel1bucket9.clear();
        

        rel2bucketPad.addAll(rel2bucket0);
        rel2bucketPad.addAll(rel2bucket1);
        rel2bucketPad.addAll(rel2bucket2);
        rel2bucketPad.addAll(rel2bucket3);
        rel2bucketPad.addAll(rel2bucket4);
        rel2bucketPad.addAll(rel2bucket5);
        rel2bucketPad.addAll(rel2bucket6);
        rel2bucketPad.addAll(rel2bucket7);
        rel2bucketPad.addAll(rel2bucket8);
        rel2bucketPad.addAll(rel2bucket9);
        //rel2bucket0.removeAll(rel2bucket0);
        //rel2bucket1.removeAll(rel2bucket1);
        //rel2bucket2.removeAll(rel2bucket2);
        //rel2bucket3.removeAll(rel2bucket3);
        //rel2bucket4.removeAll(rel2bucket4);
        //rel2bucket5.removeAll(rel2bucket5);
        //rel2bucket6.removeAll(rel2bucket6);
        //rel2bucket7.removeAll(rel2bucket7);
        //rel2bucket8.removeAll(rel2bucket8);
        //rel2bucket9.removeAll(rel2bucket9);
        rel2bucket0.clear();
        rel2bucket1.clear();
        rel2bucket2.clear();
        rel2bucket3.clear();
        rel2bucket4.clear();
        rel2bucket5.clear();
        rel2bucket6.clear();
        rel2bucket7.clear();
        rel2bucket8.clear();
        rel2bucket9.clear();
        
    }
}