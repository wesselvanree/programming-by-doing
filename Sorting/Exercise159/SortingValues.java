public class SortingValues
{
	public static void main( String[] args )
	{
		int[] arr = { 45, 87, 39, 32, 93, 86, 12, 44, 75, 50 };

		// Display the original (unsorted values)
		System.out.print("before: ");
		for ( int i=0; i<arr.length; i++ )
			System.out.print( arr[i] + " " );
		System.out.println();

		// Swap the values around to put them ascending order.

    // loop door heel de array heen
		for ( int i=0; i<arr.length; i++ )
		{
      // loop door de rest van de array maar niet degene op plek arr[i]
			for ( int j=i+1; j<arr.length; j++ )
			{
        // als getal>een van de volgende, arr[i] wordt tijdelijk opgeslagen in temp, arr[i] = arr[i], en
				if ( arr[i]>arr[j])
				{
          // arr[i] wordt tijdelijk opgeslagen in een int
          int temp = arr[i];
          // op de plek van arr[i] komt nu arr[j]
          arr[i] = arr[j];
          // op de plek van arr[j] komt nu de waarde van de originiele arr[i]
          arr[j] = temp;
				}
			}
		}

		// Display the values again, now (hopefully) sorted.
		System.out.print("after : ");
		for ( int i=0; i<arr.length; i++ )
			System.out.print( arr[i] + " " );
		System.out.println();
	}
}
