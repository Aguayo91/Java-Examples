package com.studytrails.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelExample {
	/**
	 * NetworkChannel is a channel to a network socket. The bind method binds
	 * the socket to a local address.
	 * 
	 * SelectableChannel- Defines method using what a channel can be multiplexed
	 * (used in conjunction with other channels) with the help of a Selector.
	 * Selectable channels can be used by multiple threads A selectable channel
	 * may operate in a blocking or nonblocking mode.
	 * 
	 * Selector - Selector handles the combination of multiple
	 * selectablechannels. A selectablechannel is registered to a selector. This
	 * registration is represented by a selectionKey. A selector mentions the
	 * registered keys, selected keys and cancelled keys.The operating system is
	 * checked for the readiness of each channel. As soon as a channel is ready
	 * its key is put into the selected keys. A selector may be used by
	 * concurrent threads by their selection keys may not.
	 * 
	 * AbstactSelectableChannel - Represents the basic implementation of
	 * selectable channels.It contains methods for registering, deregistering
	 * and closing channels. It also has the information of whether the channel
	 * is blocked or not and keeps a list of current keys
	 * 
	 * SocketChannel - It represents a channel for a socket, such that the
	 * channel can be selected. Socket channels support non blocking
	 * connections. Socket Channels are thread safe.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException,
			InterruptedException {
		int port = 4444;
		SocketChannel channel = SocketChannel.open();

		// we open this channel in non blocking mode
		channel.configureBlocking(false);
		channel.connect(new InetSocketAddress("localhost", port));

		while (!channel.finishConnect()) {
			// System.out.println("still connecting");
		}
		while (true) {
			// see if any message has been received
			ByteBuffer bufferA = ByteBuffer.allocate(20);
			int count = 0;
			String message = "";
			while ((count = channel.read(bufferA)) > 0) {
				// flip the buffer to start reading
				bufferA.flip();
				message += Charset.defaultCharset().decode(bufferA);

			}

			if (message.length() > 0) {
				System.out.println(message);
				// write some data into the channel
				CharBuffer buffer = CharBuffer.wrap("Hello Server");
				while (buffer.hasRemaining()) {
					channel.write(Charset.defaultCharset().encode(buffer));
				}
				message = "";
			}

		}
	}
}
