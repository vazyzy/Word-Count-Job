#@namespace scala ru.livetex.wordcount.thrift


 struct WordsEvent {
      /** Набор слов. */
      1: required string words;
    }

/**
 * Сервис слов.
 *
 * @version 0.0.1
 */
service WordsEventService {

     void sendWordEvent (1:WordsEvent wordsEvent);
}