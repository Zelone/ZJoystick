/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joystick.BasicCodes;

import java.awt.AWTEvent;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.lang.annotation.Native;

/**
 * A semantic event which indicates that a component-defined action occurred.
 * This high-level event is generated by a component (such as a
 * <code>Button</code>) when the component-specific action occurs (such as being
 * pressed). The event is passed to every <code>ActionListener</code> object
 * that registered to receive such events using the component's
 * <code>addActionListener</code> method.
 * <p>
 * <b>Note:</b> To invoke an <code>ActionEvent</code> on a <code>Button</code>
 * using the keyboard, use the Space bar.
 * <P>
 * The object that implements the <code>ActionListener</code> interface gets
 * this <code>ActionEvent</code> when the event occurs. The listener is
 * therefore spared the details of processing individual mouse movements and
 * mouse clicks, and can instead process a "meaningful" (semantic) event like
 * "button pressed".
 * <p>
 * An unspecified behavior will be caused if the {@code id} parameter of any
 * particular {@code ActionEvent} instance is not in the range from
 * {@code ACTION_FIRST} to {@code ACTION_LAST}.
 *
 * @see ActionListener
 * @see
 * <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html">Tutorial:
 * How to Write an Action Listener</a>
 *
 * @author Carl Quinn
 * @since 1.1
 */
public class JoystickEvent {

    public static final int UP_MASK = 0;
    public static final int RIGHT_MASK = 1;
    public static final int DOWN_MASK = 2;
    public static final int LEFT_MASK = 3;

    public static final int JOYSTICK_MASK = 4;
    public static final int BUTTON_MASK = 5;
    
    private static int 
    /**
     * Constructs an <code>ActionEvent</code> object.
     * <p>
     * This method throws an <code>IllegalArgumentException</code> if
     * <code>source</code> is <code>null</code>. A <code>null</code>
     * <code>command</code> string is legal, but not recommended.
     *
     * @throws IllegalArgumentException if <code>source</code> is null
     * @see #getSource()
     * @see #getID()
     * @see #getActionCommand()
     */
    public JoystickEvent() {

    }

    /**
     * Constructs an <code>ActionEvent</code> object with modifier keys.
     * <p>
     * This method throws an <code>IllegalArgumentException</code> if
     * <code>source</code> is <code>null</code>. A <code>null</code>
     * <code>command</code> string is legal, but not recommended.
     *
     * @param source The object that originated the event
     * @param id An integer that identifies the event. For information on
     * allowable values, see the class description for {@link ActionEvent}
     * @param command A string that may specify a command (possibly one of
     * several) associated with the event
     * @param modifiers The modifier keys down during event (shift, ctrl, alt,
     * meta). Passing negative parameter is not recommended. Zero value means
     * that no modifiers were passed
     * @throws IllegalArgumentException if <code>source</code> is null
     * @see #getSource()
     * @see #getID()
     * @see #getActionCommand()
     * @see #getModifiers()
     */
    public JoystickEvent(Object source, int id, String command, int modifiers) {
        this(source, id, command, 0, modifiers);
    }

    /**
     * Constructs an <code>ActionEvent</code> object with the specified modifier
     * keys and timestamp.
     * <p>
     * This method throws an <code>IllegalArgumentException</code> if
     * <code>source</code> is <code>null</code>. A <code>null</code>
     * <code>command</code> string is legal, but not recommended.
     *
     * @param source The object that originated the event
     * @param id An integer that identifies the event. For information on
     * allowable values, see the class description for {@link ActionEvent}
     * @param command A string that may specify a command (possibly one of
     * several) associated with the event
     * @param modifiers The modifier keys down during event (shift, ctrl, alt,
     * meta). Passing negative parameter is not recommended. Zero value means
     * that no modifiers were passed
     * @param when A long that gives the time the event occurred. Passing
     * negative or zero value is not recommended
     * @throws IllegalArgumentException if <code>source</code> is null
     * @see #getSource()
     * @see #getID()
     * @see #getActionCommand()
     * @see #getModifiers()
     * @see #getWhen()
     *
     * @since 1.4
     */
    public JoystickEvent(Object source, int id, String command, long when,
            int modifiers) {
        super(source, id);
    }

    /**
     * Returns the command string associated with this action. This string
     * allows a "modal" component to specify one of several commands, depending
     * on its state. For example, a single button might toggle between "show
     * details" and "hide details". The source object and the event would be the
     * same in each case, but the command string would identify the intended
     * action.
     * <p>
     * Note that if a <code>null</code> command string was passed to the
     * constructor for this <code>ActionEvent</code>, this this method returns
     * <code>null</code>.
     *
     * @return the string identifying the command for this event
     */
    public String getActionCommand() {
        return actionCommand;
    }

    /**
     * Returns the timestamp of when this event occurred. Because an ActionEvent
     * is a high-level, semantic event, the timestamp is typically the same as
     * an underlying InputEvent.
     *
     * @return this event's timestamp
     * @since 1.4
     */
    public long getWhen() {
        return when;
    }

    /**
     * Returns the modifier keys held down during this action event.
     *
     * @return the bitwise-or of the modifier constants
     */
    public int getModifiers() {
        return modifiers;
    }

    /**
     * Returns a parameter string identifying this action event. This method is
     * useful for event-logging and for debugging.
     *
     * @return a string identifying the event and its associated command
     */
    public String paramString() {
        String typeStr;
        switch (id) {
            case ACTION_PERFORMED:
                typeStr = "ACTION_PERFORMED";
                break;
            default:
                typeStr = "unknown type";
        }
        return typeStr + ",cmd=" + actionCommand + ",when=" + when + ",modifiers="
                + KeyEvent.getKeyModifiersText(modifiers);
    }
}
