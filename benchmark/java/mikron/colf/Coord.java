package mikron.colf;


// This file was generated by colf(1); DO NOT EDIT


import static java.lang.String.format;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;


/**
 * Data bean with built-in serialization support.
 * @author generated by colf(1)
 * @see <a href="https://github.com/pascaldekloe/colfer">Colfer's home</a>
 */
public class Coord implements java.io.Serializable {

	/** The upper limit for serial byte sizes. */
	public static int colferSizeMax = 16 * 1024 * 1024;


	public double x;
	public double y;


	/**
	 * {@link #reset(InputStream) Reusable} deserialization of Colfer streams.
	 */
	public static class Unmarshaller {

		/** The data source. */
		protected InputStream in;

		/** The read buffer. */
		protected byte[] buf;

		/** The {@link #buf buffer}'s data start index, inclusive. */
		protected int offset;

		/** The {@link #buf buffer}'s data end index, exclusive. */
		protected int i;


		/**
		 * @param in the data source or {@code null}.
		 * @param buf the initial buffer or {@code null}.
		 */
		public Unmarshaller(InputStream in, byte[] buf) {
			if (buf == null || buf.length == 0)
				buf = new byte[Math.min(Coord.colferSizeMax, 2048)];
			this.buf = buf;
			reset(in);
		}

		/**
		 * Reuses the marshaller.
		 * @param in the data source or {@code null}.
		 * @throws IllegalStateException on pending data.
		 */
		public void reset(InputStream in) {
			if (this.i != this.offset) throw new IllegalStateException("colfer: pending data");
			this.in = in;
			this.offset = 0;
			this.i = 0;
		}

		/**
		 * Deserializes the following object.
		 * @return the result or {@code null} when EOF.
		 * @throws IOException from the input stream.
		 * @throws SecurityException on an upper limit breach defined by {@link #colferSizeMax}.
		 * @throws InputMismatchException when the data does not match this object's schema.
		 */
		public Coord next() throws IOException {
			if (in == null) return null;

			while (true) {
				if (this.i > this.offset) {
					try {
						Coord o = new Coord();
						this.offset = o.unmarshal(this.buf, this.offset, this.i);
						return o;
					} catch (BufferUnderflowException e) {
					}
				}
				// not enough data

				if (this.i <= this.offset) {
					this.offset = 0;
					this.i = 0;
				} else if (i == buf.length) {
					byte[] src = this.buf;
					if (offset == 0) this.buf = new byte[Math.min(Coord.colferSizeMax, this.buf.length * 4)];
					System.arraycopy(src, this.offset, this.buf, 0, this.i - this.offset);
					this.i -= this.offset;
					this.offset = 0;
				}
				assert this.i < this.buf.length;

				int n = in.read(buf, i, buf.length - i);
				if (n < 0) {
					if (this.i > this.offset)
						throw new InputMismatchException("colfer: pending data with EOF");
					return null;
				}
				assert n > 0;
				i += n;
			}
		}

	}


	/**
	 * Serializes the object.
	 * @param out the data destination.
	 * @param buf the initial buffer or {@code null}.
	 * @return the final buffer. When the serial fits into {@code buf} then the return is {@code buf}.
	 *  Otherwise the return is a new buffer, large enough to hold the whole serial.
	 * @throws IOException from {@code out}.
	 * @throws IllegalStateException on an upper limit breach defined by {@link #colferSizeMax}.
	 */
	public byte[] marshal(OutputStream out, byte[] buf) throws IOException {
		if (buf == null || buf.length == 0)
			buf = new byte[Math.min(Coord.colferSizeMax, 2048)];

		while (true) {
			int i;
			try {
				i = marshal(buf, 0);
			} catch (BufferOverflowException e) {
				buf = new byte[Math.min(Coord.colferSizeMax, buf.length * 4)];
				continue;
			}

			out.write(buf, 0, i);
			return buf;
		}
	}

	/**
	 * Serializes the object.
	 * @param buf the data destination.
	 * @param offset the initial index for {@code buf}, inclusive.
	 * @return the final index for {@code buf}, exclusive.
	 * @throws BufferOverflowException when {@code buf} is too small.
	 * @throws IllegalStateException on an upper limit breach defined by {@link #colferSizeMax}.
	 */
	public int marshal(byte[] buf, int offset) {
		int i = offset;

		try {
			if (this.x != 0.0) {
				buf[i++] = (byte) 0;
				long x = Double.doubleToRawLongBits(this.x);
				buf[i++] = (byte) (x >>> 56);
				buf[i++] = (byte) (x >>> 48);
				buf[i++] = (byte) (x >>> 40);
				buf[i++] = (byte) (x >>> 32);
				buf[i++] = (byte) (x >>> 24);
				buf[i++] = (byte) (x >>> 16);
				buf[i++] = (byte) (x >>> 8);
				buf[i++] = (byte) (x);
			}

			if (this.y != 0.0) {
				buf[i++] = (byte) 1;
				long x = Double.doubleToRawLongBits(this.y);
				buf[i++] = (byte) (x >>> 56);
				buf[i++] = (byte) (x >>> 48);
				buf[i++] = (byte) (x >>> 40);
				buf[i++] = (byte) (x >>> 32);
				buf[i++] = (byte) (x >>> 24);
				buf[i++] = (byte) (x >>> 16);
				buf[i++] = (byte) (x >>> 8);
				buf[i++] = (byte) (x);
			}

			buf[i++] = (byte) 0x7f;
			return i;
		} catch (ArrayIndexOutOfBoundsException e) {
			if (i - offset > Coord.colferSizeMax)
				throw new IllegalStateException(format("colfer: mikron.Coord exceeds %d bytes", Coord.colferSizeMax));
			if (i > buf.length) throw new BufferOverflowException();
			throw e;
		}
	}

	/**
	 * Deserializes the object.
	 * @param buf the data source.
	 * @param offset the initial index for {@code buf}, inclusive.
	 * @return the final index for {@code buf}, exclusive.
	 * @throws BufferUnderflowException when {@code buf} is incomplete. (EOF)
	 * @throws SecurityException on an upper limit breach defined by {@link #colferSizeMax}.
	 * @throws InputMismatchException when the data does not match this object's schema.
	 */
	public int unmarshal(byte[] buf, int offset) {
		return unmarshal(buf, offset, buf.length);
	}

	/**
	 * Deserializes the object.
	 * @param buf the data source.
	 * @param offset the initial index for {@code buf}, inclusive.
	 * @param end the index limit for {@code buf}, exclusive.
	 * @return the final index for {@code buf}, exclusive.
	 * @throws BufferUnderflowException when {@code buf} is incomplete. (EOF)
	 * @throws SecurityException on an upper limit breach defined by {@link #colferSizeMax}.
	 * @throws InputMismatchException when the data does not match this object's schema.
	 */
	public int unmarshal(byte[] buf, int offset, int end) {
		if (end > buf.length) end = buf.length;
		int i = offset;

		try {
			byte header = buf[i++];

			if (header == (byte) 0) {
				long x = (buf[i++] & 0xffL) << 56 | (buf[i++] & 0xffL) << 48 | (buf[i++] & 0xffL) << 40 | (buf[i++] & 0xffL) << 32
					| (buf[i++] & 0xffL) << 24 | (buf[i++] & 0xffL) << 16 | (buf[i++] & 0xffL) << 8 | (buf[i++] & 0xffL);
				this.x = Double.longBitsToDouble(x);
				header = buf[i++];
			}

			if (header == (byte) 1) {
				long x = (buf[i++] & 0xffL) << 56 | (buf[i++] & 0xffL) << 48 | (buf[i++] & 0xffL) << 40 | (buf[i++] & 0xffL) << 32
					| (buf[i++] & 0xffL) << 24 | (buf[i++] & 0xffL) << 16 | (buf[i++] & 0xffL) << 8 | (buf[i++] & 0xffL);
				this.y = Double.longBitsToDouble(x);
				header = buf[i++];
			}

			if (header != (byte) 0x7f)
				throw new InputMismatchException(format("colfer: unknown header at byte %d", i - 1));
		} finally {
			if (i > end && end - offset < Coord.colferSizeMax) throw new BufferUnderflowException();
			if (i - offset > Coord.colferSizeMax)
				throw new SecurityException(format("colfer: mikron.Coord exceeds %d bytes", Coord.colferSizeMax));
			if (i > end) throw new BufferUnderflowException();
		}

		return i;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double value) {
		this.x = value;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double value) {
		this.y = value;
	}

	@Override
	public final int hashCode() {
		int h = 1;
		long _xBits = Double.doubleToLongBits(this.x);
		h = 31 * h + (int) (_xBits ^ _xBits >>> 32);
		long _yBits = Double.doubleToLongBits(this.y);
		h = 31 * h + (int) (_yBits ^ _yBits >>> 32);
		return h;
	}

	@Override
	public final boolean equals(Object o) {
		return o instanceof Coord && equals((Coord) o);
	}

	public final boolean equals(Coord o) {
		return o != null && o.getClass() == Coord.class
			&& (this.x == o.x || (this.x != this.x && o.x != o.x))
			&& (this.y == o.y || (this.y != this.y && o.y != o.y));
	}

}
