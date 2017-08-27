package com.example.jinyu.db.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.jinyu.Database.Sentence;
import com.example.jinyu.Database.Word;

import com.example.jinyu.db.gen.SentenceDao;
import com.example.jinyu.db.gen.WordDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig sentenceDaoConfig;
    private final DaoConfig wordDaoConfig;

    private final SentenceDao sentenceDao;
    private final WordDao wordDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        sentenceDaoConfig = daoConfigMap.get(SentenceDao.class).clone();
        sentenceDaoConfig.initIdentityScope(type);

        wordDaoConfig = daoConfigMap.get(WordDao.class).clone();
        wordDaoConfig.initIdentityScope(type);

        sentenceDao = new SentenceDao(sentenceDaoConfig, this);
        wordDao = new WordDao(wordDaoConfig, this);

        registerDao(Sentence.class, sentenceDao);
        registerDao(Word.class, wordDao);
    }
    
    public void clear() {
        sentenceDaoConfig.clearIdentityScope();
        wordDaoConfig.clearIdentityScope();
    }

    public SentenceDao getSentenceDao() {
        return sentenceDao;
    }

    public WordDao getWordDao() {
        return wordDao;
    }

}
