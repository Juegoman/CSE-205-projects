// Assignment #: 8
//         Name: Ruben 
//    StudentID: 
//      Lecture: MWF 9:00am
//  Description: A class with a public method to implement the merge sort 
//               algorithm on an arrayList, and associated private helper 
//               methods.

import java.util.ArrayList;

public class Sorts {
    
    public static void sort(ArrayList objects) {
        //sort the arrayList, then overwrite the parameter with the result
        ArrayList o = mergeSort(objects);
        
        objects.clear();
        
        for(Object e: o) {
            objects.add(e);
        }
        
    }
    
    private static ArrayList mergeSort(ArrayList e) {
        //if the passed array is one element long, return it
        if(e.size() == 1) {
            return e;
        }
        
        //left, right, result arrays
        ArrayList l, r, res;
        
        //get the midpoint of the array
        int mp = e.size() / 2;
        
        //fill left array with passed array from start to midpoint
        l = new ArrayList();
        for(int i = 0; i < mp; i++) {
            l.add(e.get(i));
        }
        
        //fill right array with passed array from midpoint to end
        r = new ArrayList();
        for(int i = mp; i < e.size(); i++) {
            r.add(e.get(i));
        }
        
        //call this method recursively on left and right arrays
        l = mergeSort(l);
        r = mergeSort(r);
        
        //merge the left and right arrays and put the result in the result array
        res = merge(l, r);
        
        //return result
        return res;
        
    }
    
    private static ArrayList merge(ArrayList l, ArrayList r) {
        
        //instantiate variables and result arrays
        ArrayList res = new ArrayList();
        int i = 0, j = 0;
        Comparable a, b;
        
        //while there are still elements in either left or right arrays
        while(i < l.size() || j < r.size()) {
            
            //if there are still elements in the left and right arrays
            if(i < l.size() && j < r.size()) {
                
                //cast elements to comparable to use .compareTo()
                a = (Comparable) l.get(i);
                b = (Comparable) r.get(j);
                
                //compare a to b, if a is before b then add a to the result and
                //increment associated count
                if(a.compareTo(b) < 0) {
                    
                    res.add(a);
                    i++;
                
                //otherwise add b to the result and increment associated count
                }else {
                    
                    res.add(b);
                    j++;
                    
                }
            //otherwise if the left array still has elements then add those
            //elements to the result array
            }else if(i < l.size()) {
                
                a = (Comparable) l.get(i);
                res.add(a);
                i++;
            
            //otherwise if the right array still has elements then add those
            //elements to the result array
            }else if(j < r.size()) {
                b = (Comparable) r.get(j);
                res.add(b);
                j++;
            }
        }
        
        //return the merged array
        return res;
        
    }
    
}