# Category C — Abstraction, Interface, Class vs Interface

Java solutions for Part A of the supplied PDF, plus answers for Part B and Part C.

## Part A — Coding Problems
1. Garden Plot Area Report — `Problem1GardenPlotAreaReport.java`
2. Weekly Staff Pay — `Problem2WeeklyStaffPay.java`
3. Library Late Fine Counter — `Problem3LibraryLateFineCounter.java`
4. Electricity Connection Billing — `Problem4ElectricityConnectionBilling.java`
5. Travel Booking with a Common Fee — `Problem5TravelBookingCommonFee.java`

## Part B and Part C
- `PartB_MCQ_Answers.md` — answers to the 10 quiz questions.
- `PartC_Concept_Answers.md` — answers to all 5 concept questions.

## Compile and run
Use a Java JDK. Compile and run each program separately from the repository root. Example:

```bash
javac src/Problem1GardenPlotAreaReport.java
java -cp src Problem1GardenPlotAreaReport
```

Each program has its own `main` method. Do not compile/run all files as one application; they are separate assignment solutions.

## Design
Each coding problem uses an abstract base class to keep shared data/behavior in one place and subclasses to implement type-specific calculations. The common reporting loop uses polymorphism.
