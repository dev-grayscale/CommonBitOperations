public class Main {
  /**
   * Shift a 1 bit p positions (0 based) to the left and perform AND operation.
   * Return false if 0, true otherwise.
   *
   * E.g. Get bit 1
   *
   * 0010 (1 << 1)
   * 1110
   * ----
   * 0010 != 0 -> true
   *
   */
  public static boolean get(int value, int p) {
    return ((1 << p) & value) != 0;
  }

  /**
   * In case 0 or 1 is expected
   *
   * Shift the value bits p positions to the right
   * so the bit we want to check will be at 0th position.
   * Then perform AND with ...0001 (1) which will return
   * the exact value.
   */
  public static int getV2(int value, int p) {
    return (value >> p) & 1;
  }

  /**
   * Shift 1 bit at position p then perform OR operation on value.
   *
   * If at position p, value has:
   *
   * 1 -> 1 remains (1 | 1 = 1)
   * 0 -> becomes 1 (1 | 0 = 1)
   *
   * these are all the possible scenarios.
   */
  public static int set(int value, int p) {
    return (1 << p) | value;
  }

  /**
   * Set all bits to 0 by performing AND with 0.
   *
   * Performing AND on 2 bits will have one of the outcomes below:
   *
   * (1) 0 & 0 -> 0
   * (2) 0 & 1 -> 0
   * (3) 1 & 0 -> 0
   * (4) 1 & 1 -> 1
   *
   * As the bits in the second operand are all 0s, we could only reach cases (1) and (3) which will
   * definitely produce 0.
   */
  public static int clearAll(int value) {
    return value & 0;
  }

  /**
   * To set a bit at specific position to 0 - AND operator could be used
   * along with the input and the negation of the value which contains single 1 bit
   * at the concrete position.
   */
  public static int clear(int value, int pos) {
    return value & ~(1 << pos);
  }

  /**
   * Shifting means moving the bits in a specific direction N times.
   *
   * Let's take the following example: 0010 (2) and shift it with 1 position to the left continuously
   *
   * 1. 0010 << 1 = 0100
   * 2. 0100 << 1 = 1000
   * 3. 1000 << 1 = 0000
   *
   * In summary, we move all the bits to the left, discard the most significant bit (MSB)
   * and fill the least significant bit with 0 to preserve the amount of slots based on the type.
   *
   * E.g. 1 is removed <- 1..xxxxxxx0 <- 0
   *
   * The right shift could be:
   * - logical (denoted as >>> and similar to left shift) - all the bits are moved to the right, the least significant bit (LSB) is discarded
   * and the most significant bit (MSB) is filled with 0.
   *
   * E.g. 0 -> 0...xxxxxxx1 -> 1 is removed.
   *
   * - arithmetic (>>) - all the bits are moved to the right, the least significant bit (LSB) is discarded and the most significant bit (MSB)
   * is filled with its previous value.
   *
   * E.g.
   *
   * 1...xxxxxxx1 >> 1 = 11...xxxxxxx
   * 01...xxxxxxx1 >> 1 = 001...xxxxxxx
   */

  /**
   * Shift all the bits n positions to the left
   */
  public static int shiftLeftN(int value, int n) {
    return value << n;
  }

  /**
   * Shift all the bits n positions to the right (arithmetic)
   */
  public static int shiftRightArithmeticN(int value, int n) {
    return value >> n;
  }

  /**
   * Shift all the bits n positions to the right (logical)
   */
  public static int shiftRightLogicalN(int value, int n) {
    return value >>> n;
  }

  /**
   * Masks are another option to build a bits sequence
   * that will help us to achieve a specific result.
   *
   * Let's say we want to find the 1s in the left half
   * of an int value.
   */
  public static int mask(int value) {
    int mask = -(1 << (Integer.BYTES * 8 / 2)); // 11111111111111110000000000000000

    // By using AND, the result will contain the 1s
    // from the 16 bits on the left half of the input.
    return value & mask;
  }
}
