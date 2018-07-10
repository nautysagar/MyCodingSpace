package bowling;

import java.util.Scanner;

public class Bowling {

	private Scanner keyIn = new Scanner(System.in);

	private int frameCount = 0;
	
	private int frameLength = 10;
	
	private int frameStrike = 10;
	
	private boolean lastStrike = false;
	private boolean lastSpare = false;

	private int frme[] = new int[frameLength];
	private int allfrme[][] = new int[2][frameLength+2];
	private String s;

	public Bowling() {
		for (int l1 = 0; l1 < frameLength; l1++)
			frme[l1] = 0;
		for (int l2 = 0; l2 < allfrme[0].length; l2++)
			allfrme[0][l2] = allfrme[1][l2] = 0;
	}

	public void startGame() {
		for (int i = 0; i < frameLength; i++) {
			System.out.printf("\n\t   FRAME %2d ", new Object[] { Integer.valueOf(i + 1) });
			frameCount++;
			getPinsForBall1(i);
		//	if (allfrme[0][i] == 10) continue;
		//	getPinsForBall2(i);
		}
		checkForExtraBalls();
		startPointCalculation();
		startDisplayingPoints();
	}

	

	private void checkForExtraBalls() {
		if (lastStrike) {
			int k = 1;
			lastStrike = false;
			while (k < 3) {
				System.out.printf("\n\t   Extra Frame %2d ", k);
				getPinsForBall1(frameCount++);
				k++;
				if (lastStrike) {
					lastStrike = false;
					continue;
				} else {
					break;
				}
			}

		} else if (lastSpare) {
			System.out.printf("\n\t   Extra Frame %2d ", 1);
			getPinsForBall1(frameCount++);
		}
	}

	private void getPinsForBall1(int i) {
		System.out.printf("\n\t Ball 1: ");
		int Pins = keyIn.nextInt();
		if (Pins <= 10 && Pins >= 0) {
			allfrme[0][i] = Pins;
			if (Pins == 10) {
				System.out.println("\n\t\t\tExcelent, Strike!!");
				if (i >= 9)
					lastStrike = true;
			}
			 else {
				 if (!lastSpare)
				getPinsForBall2(i);
			}

		} else {
			System.out.println("\n\t\t\tInvalid Input, Please give input from 0-10 !!");
			getPinsForBall1(i);
		}

	}

	private void getPinsForBall2(int i) {
     
		System.out.print("\n\t Ball 2: ");
		int Pins2 = keyIn.nextInt();
		if (Pins2 <= 10 && Pins2 >= 0 && Pins2 + allfrme[0][i] < 11) {
			allfrme[1][i] = Pins2;
			if (Pins2 + allfrme[0][i] == 10 && i < 10)
				System.out.println("\n\t\t\tNice, Spare!!");
			if (i == 9) lastSpare = true;
		} else {
			System.out.println("\n\t\t\tInvalid Input, Please give input from 0 - "+ (10- allfrme[0][i]) +"!!");
			getPinsForBall2(i);
		}
	}

	private void startPointCalculation() {
	
			for(int j = 0; j < frameLength; j++) 
				calculate(getStatus(0,j), 0, j);
		
	}
	
	private void calculate(BowlingEnum e,int row,int col) {
		switch(e) {
		case STRIKE:
			setStrikeData(row, col);
			break;
		case SPARE:
			setSpareData(row,col);
			break;
		case OTHER:	
			setOtherData(row,col);
			break;
		default:
			break;
		}
	}
	
	private void setOtherData(int row, int col) {
		if (col == 0) 
			 frme[col] = allfrme[row][col] + allfrme[row+1][col];
		else 
			 frme[col] = frme[col - 1] + allfrme[row][col] + allfrme[row+1][col];
		
	}

	private void setSpareData(int row, int col) {
		if (col == 0) 
			frme[col] = 10 + allfrme[row][col+1];
		else 
			frme[col] = frme[col-1] + 10 + allfrme[row][col+1];
		
	}

	private BowlingEnum getStatus(int row, int col) {
		if (allfrme[row][col] == 10) {
			return BowlingEnum.STRIKE;
		} else if(allfrme[row][col] + allfrme[row+1][col] == 10) {
			return BowlingEnum.SPARE;
		} else {
			return BowlingEnum.OTHER;
		}
	}
	
	private void setStrikeData(int row,int col) {
		if (col == 0) {
			if (allfrme[row][col+1] == 10) {
				frme[col] = 20 + allfrme[0][col+2];
			} else {
				frme[col] = 10 + allfrme[row][col+1] + allfrme[row+1][col+1];
			}
		} else {
			if (allfrme[row][col+1] == 10) {
				frme[col] = frme[col - 1] + 20 + allfrme[0][col+2];
				
			} else {
				frme[col] = frme[col - 1] + 10 + allfrme[row][col+1] + allfrme[row+1][col+1];
				
			}
		}
		
	}
	
	private void startDisplayingPoints() {
		System.out.print("\n\n\t  FRAME");
		  for(int k = 1; k < 11; k++)
			 System.out.printf("%4d", new Object[] {
			   Integer.valueOf(k) });

		   if(allfrme[0][9] == 10) {
			 if(allfrme[0][10] == 10)
			   System.out.print("  XTR1 XTR2");
			 else
			   System.out.print("  EXTRA");

		   }else if(allfrme[0][9] + allfrme[1][9] == 10)
			System.out.print("  XTRA");
			System.out.print("\n\n\tBall 1 ");

		  for(int l = 0; l < 10; l++)
				System.out.printf("%4d", new Object[] {
					Integer.valueOf(allfrme[0][l])
				});

		 if(allfrme[0][9] == 10)	{
		  if(allfrme[0][10] == 10)
		    System.out.printf("%4d%4d", new Object[] {
		     Integer.valueOf(allfrme[0][10]), Integer.valueOf(allfrme[0][11]) });
		   else
		      System.out.printf("%4d", new Object[] {
		       Integer.valueOf(allfrme[0][10]) });

		 } else
		  if(allfrme[0][9] + allfrme[1][9] == 10)
			System.out.printf("%4d", new Object[] {
				Integer.valueOf(allfrme[0][10])
			});
		    System.out.print("\n\tBall 2 ");
		  for(int i1 = 0; i1 < 10; i1++)
			System.out.printf("%4d", new Object[] {
				Integer.valueOf(allfrme[1][i1])
			});

		  if(allfrme[0][9] == 10 && allfrme[0][10] != 10)
			System.out.printf("%4d", new Object[] {
				Integer.valueOf(allfrme[1][10])
			});

		    System.out.print("\n\n\t  SCORE");
		  for(int j1 = 0; j1 < 10; j1++)
			System.out.printf("%4d", new Object[] {
				Integer.valueOf(frme[j1])
			});
		
	}

}
