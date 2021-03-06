/**
 * Generated by Scrooge
 *   version: 3.16.3
 *   rev: b8593c83072d94fc44feaa8d97940b9266d84ed0
 *   built at: 20140806-054445
 */
package ru.livetex.wordcount.thrift

import com.twitter.scrooge.{
  TFieldBlob, ThriftException, ThriftStruct, ThriftStructCodec3, ThriftStructFieldInfo, ThriftUtil}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport}
import java.nio.ByteBuffer
import java.util.Arrays
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object WordsEvent extends ThriftStructCodec3[WordsEvent] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("WordsEvent")
  val WordsField = new TField("words", TType.STRING, 1)
  val WordsFieldManifest = implicitly[Manifest[String]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      WordsField,
      false,
      WordsFieldManifest,
      None,
      None,
      immutable$Map(
      ),
      immutable$Map(
      )
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map[String, String](
    )

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: WordsEvent) {
    if (_item.words == null) throw new TProtocolException("Required field words cannot be null")
  }

  override def encode(_item: WordsEvent, _oproto: TProtocol) {
    _item.write(_oproto)
  }

  override def decode(_iprot: TProtocol): WordsEvent = {
    var words: String = null
    var _got_words = false
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRING => {
                words = readWordsValue(_iprot)
                _got_words = true
              }
              case _actualType =>
                val _expectedType = TType.STRING
            
                throw new TProtocolException(
                  "Received wrong type for field 'words' (expected=%s, actual=%s).".format(
                    ttypeToHuman(_expectedType),
                    ttypeToHuman(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_words) throw new TProtocolException("Required field 'words' was not found in serialized data for struct WordsEvent")
    new Immutable(
      words,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    words: String
  ): WordsEvent =
    new Immutable(
      words
    )

  def unapply(_item: WordsEvent): Option[String] = Some(_item.words)


  private def readWordsValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  private def writeWordsField(words_item: String, _oprot: TProtocol) {
    _oprot.writeFieldBegin(WordsField)
    writeWordsValue(words_item, _oprot)
    _oprot.writeFieldEnd()
  }

  private def writeWordsValue(words_item: String, _oprot: TProtocol) {
    _oprot.writeString(words_item)
  }



  private def ttypeToHuman(byte: Byte) = {
    // from https://github.com/apache/thrift/blob/master/lib/java/src/org/apache/thrift/protocol/TType.java
    byte match {
      case TType.STOP   => "STOP"
      case TType.VOID   => "VOID"
      case TType.BOOL   => "BOOL"
      case TType.BYTE   => "BYTE"
      case TType.DOUBLE => "DOUBLE"
      case TType.I16    => "I16"
      case TType.I32    => "I32"
      case TType.I64    => "I64"
      case TType.STRING => "STRING"
      case TType.STRUCT => "STRUCT"
      case TType.MAP    => "MAP"
      case TType.SET    => "SET"
      case TType.LIST   => "LIST"
      case TType.ENUM   => "ENUM"
      case _            => "UNKNOWN"
    }
  }

  object Immutable extends ThriftStructCodec3[WordsEvent] {
    override def encode(_item: WordsEvent, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): WordsEvent = WordsEvent.decode(_iprot)
  }

  /**
   * The default read-only implementation of WordsEvent.  You typically should not need to
   * directly reference this class; instead, use the WordsEvent.apply method to construct
   * new instances.
   */
  class Immutable(
    val words: String,
    override val _passthroughFields: immutable$Map[Short, TFieldBlob]
  ) extends WordsEvent {
    def this(
      words: String
    ) = this(
      words,
      Map.empty
    )
  }

  /**
   * This Proxy trait allows you to extend the WordsEvent trait with additional state or
   * behavior and implement the read-only methods from WordsEvent using an underlying
   * instance.
   */
  trait Proxy extends WordsEvent {
    protected def _underlying_WordsEvent: WordsEvent
    override def words: String = _underlying_WordsEvent.words
    override def _passthroughFields = _underlying_WordsEvent._passthroughFields
  }
}

trait WordsEvent
  extends ThriftStruct
  with scala.Product1[String]
  with java.io.Serializable
{
  import WordsEvent._

  def words: String

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = words

  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returend.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) orElse {
      val _fieldOpt: Option[TField] =
        _fieldId match {
          case 1 =>
            if (words ne null) {
              writeWordsValue(words, _oprot)
              Some(WordsEvent.WordsField)
            } else {
              None
            }
          case _ => None
        }
      _fieldOpt match {
        case Some(_field) =>
          val _data = Arrays.copyOfRange(_buff.getArray, 0, _buff.length)
          Some(TFieldBlob(_field, _data))
        case None =>
          None
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): WordsEvent = {
    var words: String = this.words
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        words = readWordsValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      words,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is subtracked
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): WordsEvent = {
    var words: String = this.words

    _fieldId match {
      case 1 =>
        words = null
      case _ =>
    }
    new Immutable(
      words,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is subtracked
   * from the passthroughFields map, if present.
   */
  def unsetWords: WordsEvent = unsetField(1)


  override def write(_oprot: TProtocol) {
    WordsEvent.validate(this)
    _oprot.writeStructBegin(Struct)
    if (words ne null) writeWordsField(words, _oprot)
    _passthroughFields.values foreach { _.write(_oprot) }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    words: String = this.words,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): WordsEvent =
    new Immutable(
      words,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[WordsEvent]

  override def equals(other: Any): Boolean =
    _root_.scala.runtime.ScalaRunTime._equals(this, other) &&
      _passthroughFields == other.asInstanceOf[WordsEvent]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 1

  override def productElement(n: Int): Any = n match {
    case 0 => this.words
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "WordsEvent"
}